package project2;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment() {
        size = 4;
        enrollStudents = new EnrollStudent[size];
    }
    public void grow() {
        EnrollStudent[] temporary = new EnrollStudent[size + 4];
        for (int x = 0; x < size; x++){
            temporary[x] = enrollStudents[x];
        }
        enrollStudents = temporary;
        size += 4;
    }

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


    public void remove(EnrollStudent enrollStudent) {

    } //move the last one in the array to replace the deleting index position
    public boolean contains(EnrollStudent enrollStudent){
        for (int x = 0; x < size; x++) {
            if(enrollStudents[x] != null) {
                if(enrollStudents[x].equals(enrollStudent))
                    return true;
            }
        }
        return false;
    }
    public void print() {
        for(int i = 0; i < size; i++) {
            if(enrollStudents[i] != null)
                System.out.println(enrollStudents[i]);
        }
    } //print the array as is without sorting
}