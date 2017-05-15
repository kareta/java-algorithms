package kareta.lab5;

/**
 * Created by vitya on 27.03.17.
 */
public class Student {
    private String name;
    private String surname;
    private String group;
    private double avarageGrade;
    private String phoneNumber;
    private int course;

    public Student(String name, String surname, String group, double avarageGrade, String phoneNumber, int course) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.avarageGrade = avarageGrade;
        this.phoneNumber = phoneNumber;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAvarageGrade() {
        return avarageGrade;
    }

    public void setAvarageGrade(double avarageGrade) {
        this.avarageGrade = avarageGrade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "" +
                "averageGrade='" + avarageGrade + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", name=" + name +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", course='" + course + '\'';
    }
}
