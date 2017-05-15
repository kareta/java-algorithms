package kareta.lab3.student;

/**
 * Created by vitya on 14.02.17.
 */
public class Person {

    private String surname;
    private String citizenship;

    public Person(String surname, String citizenship) {
        this.surname = surname;
        this.citizenship = citizenship;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return "surname='" + surname + '\'' +
                ", citizenship='" + citizenship + '\'';
    }
}
