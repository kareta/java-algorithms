package kareta.lab9;

import java.util.Scanner;

/**
 * Created by vitya on 15.05.17.
 */
public class Main {

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of students?");
        int numberOfStudents = scanner.nextInt();

        System.out.println("Team size?");
        int teamSize = scanner.nextInt();

        long numerator = factorial(numberOfStudents);
        long denominator = factorial(teamSize) * factorial(numberOfStudents - teamSize);

        System.out.println("Result is " + numerator / denominator);
    }
}
