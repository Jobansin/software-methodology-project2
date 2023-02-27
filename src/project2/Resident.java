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

    public Resident(String first, String last, String birth) {
        super(first, last, birth);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        return 0;
    }

    @Override
    public boolean isResident() {
        return true;
    }

    @Override
    public String typeStudent() {
        return "Resident";
    }

    /**
     * This is a method that sets the scholarship amount for the Resident object.
     *
     * @author David Harianto, Joban Singh
     */
    public void setScholarship(int amount) {
        scholarship = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " (resident)";
    }

}
