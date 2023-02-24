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
        Roster roster;
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
                    else if(command.equals("AR")) {

                    }
                    else if(command.equals("AN")) {

                    }
                    else if(command.equals("AT")) {

                    }
                    else if(command.equals("AI")) {

                    }
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
                    else if(command.equals("Q")) {
                        break;
                    }
                    else
                        System.out.println(command + " is an invalid command!");
                }
                catch(NoSuchElementException e) {
                    System.out.println("Missing data in line command.");
                }
//                if(command.equals("A")) { // Add student to the roster
//                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken());
//                    try {
//                        int credit = Integer.parseInt(st1.nextToken());
//                        temp.setCredit(credit);
//                        roster.add(temp);
//                    }
//                    catch (NumberFormatException e) {
//                        System.out.println("Credits completed invalid: not an integer!");
//                    }
//                }
//                else if(command.equals("R")) {
//                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
//                    roster.remove(temp);
//                }
//                else if(command.equals("P"))
//                    roster.print();
//                else if(command.equals("PS"))
//                    roster.printByStanding();
//                else if(command.equals("PC"))
//                    roster.printBySchoolMajor();
//                else if(command.equals("L"))
//                    roster.printSchool(st1.nextToken());
//                else if(command.equals("C")) {
//                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
//                    roster.majorChange(temp, st1.nextToken());
//                }

            }
        }
        System.out.println("Tuition Manager terminated.");
    }
    public Roster readFile(String file) {
        Roster roster = new Roster();
        try {
            Scanner scanner = new Scanner(new File(file));
            while(scanner.hasNextLine()) {
                StringTokenizer list = new StringTokenizer(scanner.nextLine(), ",");
                String studentType = list.nextToken();
                if(studentType.equals("R")) {
                    Resident student = new Resident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                    roster.add(student);
                }
                else if(studentType.equals("I")) {
                    Resident student = new Resident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                }
                else if(studentType.equals("R")) {
                    Resident student = new Resident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                }
                else if(studentType.equals("R")) {
                    Resident student = new Resident(list.nextToken(), list.nextToken(), list.nextToken(),
                            list.nextToken(), Double.parseDouble(list.nextToken()));
                }
            }
            return roster;
        }
        catch(FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
        return null;
    }
}
