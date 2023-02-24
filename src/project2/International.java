package project2;

public class International extends NonResident{

    private boolean isStudyAbroad;

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
    public International(String first, String last, String birth, String m, double credits) {
        super(first, last, birth, m, credits);
        isStudyAbroad = false;
    }
    public International(String first, String last, String birth, String m, double credits, boolean studyAbroad) {
        super(first, last, birth, m, credits);
        isStudyAbroad = studyAbroad;
    }
}
