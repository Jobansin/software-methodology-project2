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
        while(in.hasNextLine()) {
            String input = in.nextLine();
            if(!input.isEmpty()) {
                StringTokenizer st1 = new StringTokenizer(input, " ");
                try {
                    String command = st1.nextToken();
                    if(command.equals("LS")) {
                        roster = readFile(st1.nextToken());
                        if(roster != null)
                            System.out.println("Students loaded to the roster.");
                    }
                    else if(command.equals("AR"))
                        roster = addStudents(roster, command, st1);
                    else if(command.equals("AN"))
                        roster = addStudents(roster, command, st1);
                    else if(command.equals("AT"))
                        roster = addStudents(roster, command, st1);
                    else if(command.equals("AI"))
                        roster = addStudents(roster, command, st1);
                    else if(command.equals("E")) {

                    }
                    else if(command.equals("D")) {

                    }
                    else if(command.equals("S")) {

                    }
                    else if(command.equals("PE")) {

                    }
                    else if(command.equals("PT")) {

                    }
                    else if(command.equals("SE")) {

                    }
                    else if(command.equals("P"))
                        roster.print();
                    else if(command.equals("PS"))
                        roster.printByStanding();
                    else if(command.equals("PC"))
                        roster.printBySchoolMajor();
                    else if(command.equals("L"))
                        roster.printSchool(st1.nextToken());
                    else if(command.equals("Q")) {
                        break;
                    }
                    else
                        System.out.println(command + " is an invalid command!");
                }
                catch(NoSuchElementException e) {
                    System.out.println("Missing data in line command.");
                }
//                else if(command.equals("R")) {
//                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
//                    roster.remove(temp);
//                }

//                else if(command.equals("C")) {
//                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
//                    roster.majorChange(temp, st1.nextToken());
//                }

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

    public Roster addStudents(Roster students, String studentType, StringTokenizer list) {
        try {
            String first = list.nextToken();
            String last = list.nextToken();
            String dob = list.nextToken();
            String major = list.nextToken();
            int credit = 0;
            try {
                credit = Integer.parseInt(list.nextToken());
            }
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
                        if (added) {
                            students.studentAdded(student);
                        }
                    }
                    else {
                        System.out.println(state + ": Invalid state code.");
                    }
                }
                else {
                    System.out.println("Missing the state code.");
                }
            }
            else if (studentType.equals("AN")) {
                NonResident student = new NonResident(first, last, dob, major, credit);
                boolean added = students.add(student);
                if(added) { students.studentAdded(student); }
            }
            return students;
        }
        catch(NoSuchElementException e) {
            System.out.println("Missing data in line command.");
        }
        return students;
    }
}
