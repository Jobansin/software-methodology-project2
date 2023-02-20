package project2;

public class NonResident extends Student{
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
