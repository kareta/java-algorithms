package kareta.lab5;

import java.util.Scanner;

/**
 * Created by vitya on 27.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Student[] rawStudents = StudentsInput.inputStudents();

        StudentsArray students = new StudentsArray(rawStudents.length);

        for (Student rawStudent : rawStudents) {
            boolean added = students.add(rawStudent);
            System.out.println(rawStudent + " " + added);
        }

        System.out.println("\nUnsorted students\n" + students);
        students.sort();
        System.out.println("Sorted students\n" + students);

        System.out.println("What average grade to find?");
        double averageGrade = new Scanner(System.in).nextDouble();

        Student student = students.interpolationSearch(averageGrade);
        String message = student != null ?
                "Found student: " + student : "Student is not found.";
        System.out.println(message);
    }
}
