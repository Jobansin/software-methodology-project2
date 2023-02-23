package project2;

public class NonResident extends Student{
    /**
     * This is a constructor that takes in 5 parameters for a student.
     *
     * @param first
     * @param last
     * @param birth
     * @param m
     * @param credits
     * @author David Harianto, Joban Singh
     */
    public NonResident(String first, String last, String birth, String m, double credits) {
        super(first, last, birth, m, credits);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        return 0;
    }

    @Override
    public boolean isResident() {
        return false;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
