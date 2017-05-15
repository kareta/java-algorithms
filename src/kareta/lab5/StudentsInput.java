package kareta.lab5;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by vitya on 27.03.17.
 */
public class StudentsInput {
    public static String[] names = new String[]{"Vasya", "Petya", "Sasha", "Vitya", "Yaroslav"};
    public static String[] surnames = new String[]{"Kuzmin", "Huk", "Gordienko", "Isaiev"};
    public static String[] groups = new String[]{"5", "2-1", "1a", "3", "10", "6"};
    public static String[] phones = new String[]{"453452", "657463", "234234", "45453"};

    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static Student getStudent() {
        int nameRandom = Math.abs(rand.nextInt()) % names.length;
        int groupRandom = Math.abs(rand.nextInt()) % groups.length;
        int surnameRandom = Math.abs(rand.nextInt()) % surnames.length;
        int phonesRandom = Math.abs(rand.nextInt()) % phones.length;
        double averageGrade = Math.abs(((rand.nextInt()) % 30) / 10.0) + 2;
        int course = Math.abs(rand.nextInt()) % 5 + 1;
        averageGrade = (double) Math.round(averageGrade * 10d) / 10d;


        return new Student(
                names[nameRandom], surnames[surnameRandom],
                groups[groupRandom], averageGrade, phones[phonesRandom], course
        );
    }

    public static Student[] inputStudents() {
        System.out.println("Type students number:");
        int studentsNumber = scanner.nextInt();

        Student[] students = new Student[studentsNumber];

        for (int i = 0; i < studentsNumber; i++) {
            students[i] = getStudent();
        }

        return students;
    }

}
