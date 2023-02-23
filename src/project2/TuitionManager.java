package project2;

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
        System.out.println("Roster Manager running...");
        Roster roster = new Roster();
        while(in.hasNextLine()) {
            String input = in.nextLine();
            if(!input.isEmpty()) {
                StringTokenizer st1 = new StringTokenizer(input, " ");
                String command = st1.nextToken();
                if(command.equals("A")) { // Add student to the roster
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken());
                    try {
                        int credit = Integer.parseInt(st1.nextToken());
                        temp.setCredit(credit);
                        roster.add(temp);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Credits completed invalid: not an integer!");
                    }
                }
                else if(command.equals("R")) {
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
                    roster.remove(temp);
                }
                else if(command.equals("P"))
                    roster.print();
                else if(command.equals("PS"))
                    roster.printByStanding();
                else if(command.equals("PC"))
                    roster.printBySchoolMajor();
                else if(command.equals("L"))
                    roster.printSchool(st1.nextToken());
                else if(command.equals("C")) {
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
                    roster.majorChange(temp, st1.nextToken());
                }
                else if(command.equals("Q"))
                    break;
                else
                    System.out.println(command + " is an invalid command!");
            }
        }
        System.out.println("Roster Manager terminated.");
    }
}
