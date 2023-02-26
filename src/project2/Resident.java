package project2;

public class Resident extends Student{

    private int scholarship;

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
    public Resident(String first, String last, String birth, String m, double credits) {
        super(first, last, birth, m, credits);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        return 0;
    }

    @Override
    public boolean isResident() {
        return true;
    }

}
