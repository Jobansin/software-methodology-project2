package project2;

/**
 Represents an EnrollStudent object which holds a Profile object and credits completed.
 @author David Harianto, Joban Singh
 **/
public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    /**
     This is a constructor that takes in 2 parameters for an EnrollStudent object.
     @author David Harianto, Joban Singh
     **/
    public EnrollStudent(Profile p, int credits) {
        profile = p;
        creditsEnrolled = credits;
    }

    /**
     This method checks if the student given is the same student.
     @author David Harianto, Joban Singh
     **/
    @Override
    public boolean equals(Object object) {
        // Compare two students
        if(this == object) {
            return true;
        }
        if(!(object instanceof Student)) {
            return false;
        }
        EnrollStudent s = (EnrollStudent) object;
        return this.profile.equals(s.profile);
    }

    /**
     This method returns the first name, last name, date of birth, and credits completed.
     @author David Harianto, Joban Singh
     **/
    public String toString() {
        return profile + " credits completed: " + creditsEnrolled;
    }
}