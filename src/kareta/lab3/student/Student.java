package kareta.lab3.student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vitya on 14.02.17.
 */
public class Student extends Person {
    //academic year
    //identity card
    //academic results

    private byte academicYear;
    private int identityCard;
    private HashMap<String, ArrayList<Integer>> academicResults;

    public Student(String surname, String citizenship, byte academicYear,
          int identityCard, HashMap<String, ArrayList<Integer>> academicResults
    ) {
        super(surname, citizenship);
        this.academicYear = academicYear;
        this.identityCard = identityCard;
        this.academicResults = academicResults;
    }

    public byte getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(byte academicYear) {
        if (academicYear <= 0 || academicYear >= 7) {
            return;
        }
        this.academicYear = academicYear;
    }

    public int getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(int identityCard) {
        this.identityCard = identityCard;
    }

    public HashMap<String, ArrayList<Integer>> getAcademicResults() {
        return academicResults;
    }

    public void setAcademicResults(HashMap<String, ArrayList<Integer>> academicResults) {
        this.academicResults = academicResults;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                " academicYear=" + academicYear +
                ", identityCard='" + identityCard + '\'' +
                ", academicResults=" + academicResults +
                '}';
    }
}
