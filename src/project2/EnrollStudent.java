package project2;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    @Override
    public boolean equals(Object object) {

    }

    public String toString() {
        return profile + " credits completed: " + creditsEnrolled;
    }
}