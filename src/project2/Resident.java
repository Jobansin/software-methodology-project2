package project2;

public class Resident extends Student{

    private int scholarship;
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
