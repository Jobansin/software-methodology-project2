package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 Represents a TuitionManager object which allows the user to enter commands
 @author David Harianto, Joban Singh
 **/
public class TuitionManager {

    /**
     Default constructor.
     @author David Harianto, Joban Singh
     **/
    public TuitionManager() {

    }

    /**
     Method that accepts user input and based on the input provided does a command.
     @author David Harianto, Joban Singh
     **/
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tuition Manager running...");
        Roster roster = new Roster();
        Enrollment enrollment = new Enrollment();
        while(in.hasNextLine()) {
            String input = in.nextLine();
            if(!input.isEmpty()) {
                StringTokenizer st1 = new StringTokenizer(input, " ");
                try {
                    String command = st1.nextToken();
                    if(command.equals("LS")) {
                        roster = readFile(st1.nextToken());
                        if(roster != null) { System.out.println("Students loaded to the roster."); }
                    }
                    else if(command.equals("AR")) { roster = addStudents(roster, command, st1); }
                    else if(command.equals("AN")) { roster = addStudents(roster, command, st1); }
                    else if(command.equals("AT")) { roster = addStudents(roster, command, st1); }
                    else if(command.equals("AI")) { roster = addStudents(roster, command, st1); }
                    else if(command.equals("R")) { roster.remove(new Resident(st1.nextToken(), st1.nextToken(), st1.nextToken())); }
                    else if(command.equals("C")) { roster.majorChange(new Resident(st1.nextToken(), st1.nextToken(), st1.nextToken()), st1.nextToken()); }
                    else if(command.equals("E")) { enrollment = enrollStudents(roster, enrollment, st1); }
                    else if(command.equals("D")) { enrollment = dropStudents(roster, enrollment, st1); }
                    else if(command.equals("S")) { enrollment = setScholarship(roster, enrollment, st1); }
                    else if(command.equals("PE")) { enrollment.print(); }
                    else if(command.equals("PT")) {
                        /* Joban's Part (Tuition Stuff) */
                    }
                    else if(command.equals("SE")) { enrollment.printGraduation(roster); }
                    else if(command.equals("P")) { roster.print(); }
                    else if(command.equals("PS")) { roster.printByStanding(); }
                    else if(command.equals("PC")) { roster.printBySchoolMajor(); }
                    else if(command.equals("L")) { roster.printSchool(st1.nextToken()); }
                    else if(command.equals("Q")) { break; }
                    else { System.out.println(command + " is an invalid command!"); }
                }
                catch(NoSuchElementException e) { System.out.println("Missing data in line command."); }
            }
        }
        System.out.println("Tuition Manager terminated.");
    }
    /**
     Method reads a file of students and puts them into an array from the Roster class.
     @author David Harianto, Joban Singh
     **/
    public Roster readFile(String file) {
        Roster roster = new Roster();
        try {
            Scanner scanner = new Scanner(new File("src/" + file));
            while(scanner.hasNextLine()) {
                StringTokenizer list = new StringTokenizer(scanner.nextLine(), ",");
                String studentType = list.nextToken();
                if(studentType.equals("R")) {
                    Resident student = new Resident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                    roster.add(student);
                }
                else if(studentType.equals("I")) {
                    International student = new International(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()), list.nextToken());
                    roster.add(student);
                }
                else if(studentType.equals("T")) {
                    TriState student = new TriState(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()), list.nextToken());
                    roster.add(student);
                }
                else if(studentType.equals("N")) {
                    NonResident student = new NonResident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                    roster.add(student);
                }
            }
            return roster;
        }
        catch(FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
        return null;
    }

    /**
     Method that accepts user input and based on the input provided adds a child class of student to the roster array.
     @author David Harianto, Joban Singh
     **/
    public Roster addStudents(Roster students, String studentType, StringTokenizer list) {
        try {
            String first = list.nextToken();
            String last = list.nextToken();
            String dob = list.nextToken();
            String major = list.nextToken();
            int credit = 0;
            try { credit = Integer.parseInt(list.nextToken()); }
            catch (NumberFormatException e) {
                System.out.println("Credits completed invalid: not an integer!");
                return students;
            }
            if (studentType.equals("AR")) {
                Resident student = new Resident(first, last, dob, major, credit);
                boolean added = students.add(student);
                if(added) { students.studentAdded(student); }
            }
            else if (studentType.equals("AI")) {
                if(list.hasMoreTokens()) {
                    String studyAbroad = list.nextToken();
                    International student = new International(first, last, dob, major, credit, studyAbroad);
                    boolean added = students.add(student);
                    if(added) { students.studentAdded(student); }
                }
                else {
                    International student = new International(first, last, dob, major, credit);
                    boolean added = students.add(student);
                    if(added) { students.studentAdded(student); }
                }
            }
            else if (studentType.equals("AT")) {
                if(list.hasMoreTokens())
                {
                    String state = list.nextToken();
                    TriState student = new TriState(first, last, dob, major, credit, state);
                    if(student.validState()) {
                        boolean added = students.add(student);
                        if (added) { students.studentAdded(student); }
                    }
                    else { System.out.println(state + ": Invalid state code."); }
                }
                else { System.out.println("Missing the state code."); }
            }
            else if (studentType.equals("AN")) {
                NonResident student = new NonResident(first, last, dob, major, credit);
                boolean added = students.add(student);
                if(added) { students.studentAdded(student); }
            }
            return students;
        }
        catch(NoSuchElementException e) { System.out.println("Missing data in line command."); }
        return students;
    }

    /**
     Method that adds a student to the Enrollment array.
     @author David Harianto, Joban Singh
     **/
    public Enrollment enrollStudents(Roster roster, Enrollment enrollment, StringTokenizer list) {
        try {
            Resident temp = new Resident(list.nextToken(), list.nextToken(), list.nextToken());
            int credit = 0;
            try { credit = Integer.parseInt(list.nextToken()); }
            catch (NumberFormatException e) {
                System.out.println("Credits enrolled is not an integer.");
                return enrollment;
            }
            if(!roster.contains(temp)) { System.out.println("Cannot enroll: " + temp.getProfile() + " is not in the roster."); }
            else {
                Student s = roster.getStudent(temp);
                if(credit > 24 || credit < 3) {
                    System.out.println("(" + s.typeStudent() + ") " + credit + ": invalid credit hours.");
                }
                else if(s instanceof International && ((International) s).isStudyAbroad() && credit > 12) {
                    System.out.println("(" + s.typeStudent() + ") " + credit + ": invalid credit hours.");
                }
                else if(s instanceof International && !((International) s).isStudyAbroad() && credit < 12) {
                    System.out.println("(" + s.typeStudent() + ") " + credit + ": invalid credit hours.");
                }
                else {
                    System.out.println(s.getProfile() + " enrolled " + credit + " credits");
                    EnrollStudent temp2 = new EnrollStudent(s.getProfile(), credit);
                    if(enrollment.contains(temp2)) { enrollment.changeCredit(temp2, credit); }
                    else { enrollment.add(temp2); }
                }
            }
        }
        catch(NoSuchElementException e) { System.out.println("Missing data in line command."); }
        return enrollment;
    }

    /**
     Method that drops a student from the Enrollment array.
     @author David Harianto, Joban Singh
     **/
    public Enrollment dropStudents(Roster roster, Enrollment enrollment, StringTokenizer list) {
        try {
            EnrollStudent temp = new EnrollStudent((new Profile(list.nextToken(), list.nextToken(), new Date(list.nextToken()))), 0);
            if(!enrollment.contains(temp)) { System.out.println(temp.getProfile() + " is not enrolled."); }
            else {
                enrollment.remove(temp);
                System.out.println(temp.getProfile() + " dropped.");
            }
        }
        catch(NoSuchElementException e) { System.out.println("Missing data in line command."); }
        return enrollment;
    }

    /**
     Method that sets the scholarship amount to a given Resident object.
     @author David Harianto, Joban Singh
     **/
    public Enrollment setScholarship(Roster roster, Enrollment enrollment, StringTokenizer list) {
        try {
            Resident temp = new Resident(list.nextToken(), list.nextToken(), list.nextToken());
            int scholarship = 0;
            try { scholarship = Integer.parseInt(list.nextToken()); }
            catch (NumberFormatException e) {
                System.out.println("Amount is not an integer.");
                return enrollment;
            }
            if(!enrollment.contains(new EnrollStudent(temp.getProfile(), 0))) { System.out.println(temp.getProfile() + " is not in the roster."); }
            else {
                Student s = roster.getStudent(temp);
                if(!(s instanceof Resident)) { System.out.println(s.getProfile() + " (" + s.typeStudent() + ") is not eligible for the scholarship."); }
                else if(scholarship > 10000 || scholarship <= 0) { System.out.println(scholarship + ": invalid amount."); }
                else if(enrollment.getStudent(new EnrollStudent(temp.getProfile(), 0)).getCreditsEnrolled() < 12) {
                    System.out.println(s.getProfile() + " part time student is not eligible for the scholarship.");
                }
                else {
                    ((Resident) s).setScholarship(scholarship);
                    System.out.println(s.getProfile() + ": scholarship amount updated.");
                }
            }
        }
        catch(NoSuchElementException e) { System.out.println("Missing data in line command."); }
        return enrollment;
    }
}

