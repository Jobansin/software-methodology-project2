package project2;

/**
 Represents a Enrollment object which holds an array of EnrollStudent
 @author David Harianto, Joban Singh
 **/
public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;


    /**
     This method sets the array size to 4.
     @author David Harianto, Joban Singh
     **/
    public Enrollment() {
        size = 4;
        enrollStudents = new EnrollStudent[size];
    }

    /**
     This method increases the array capacity by 4.
     @author David Harianto, Joban Singh
     **/
    public void grow() {
        EnrollStudent[] temporary = new EnrollStudent[size + 4];
        for (int x = 0; x < size; x++){
            temporary[x] = enrollStudents[x];
        }
        enrollStudents = temporary;
        size += 4;
    }

    /**
     This method adds an EnrollStudent object to the end of the array.
     @author David Harianto, Joban Singh
     **/
    public void add(EnrollStudent enrollStudent){
        if(enrollStudents[size - 1] != null) {
            this.grow();
        }
        for (int x = 0; x < size; x++) {
            if (enrollStudents[x] == null) {
                enrollStudents[x] = enrollStudent;
                break;
            }
        }
    } //add to the end of array

    /**
     This method removes an EnrollStudent object from the array and places the last object in the
     array at the removed object's index.
     @author David Harianto, Joban Singh
     **/
    public void remove(EnrollStudent enrollStudent) {
        if(isEmpty()) {
            System.out.println("Enrollment is empty!");
        }
        else if(!contains(enrollStudent)) {
            System.out.println("Cannot enroll: " + enrollStudent + " is not in the roster.");
        }
        else {
            // Get index of last student
            int indexLastStudent = 0;
            EnrollStudent lastStudent = null;
            for (int x = 0; x < size; x++) {
                if(enrollStudents[x] != null) {
                    indexLastStudent = x;
                    lastStudent = enrollStudents[x];
                }
            }
            // Replace the removed student with the last student
            for (int x = 0; x < size; x++) {
                if(enrollStudents[x].equals(enrollStudent)) {
                    enrollStudents[x] = lastStudent;
                    break;
                }
            }
        }
    } //move the last one in the array to replace the deleting index position

    /**
     This method checks if the array contains a specific EnrollStudent object.
     @author David Harianto, Joban Singh
     **/
    public boolean contains(EnrollStudent enrollStudent){
        if (!isEmpty()) {
            for (int x = 0; x < size; x++) {
                if (enrollStudents[x] != null) {
                    if (enrollStudents[x].equals(enrollStudent))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     This method returns if the array is empty or not.
     @author David Harianto, Joban Singh
     **/
    public boolean isEmpty() {
        for (int x = 0; x < size; x++) {
            if (enrollStudents[x] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     This method prints out all the EnrollStudent objects in the array unsorted.
     @author David Harianto, Joban Singh
     **/
    public void print() {
        for(int i = 0; i < size; i++) {
            if(enrollStudents[i] != null)
                System.out.println(enrollStudents[i]);
        }
    } //print the array as is without sorting
}