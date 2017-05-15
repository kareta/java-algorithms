package kareta.lab7;

import kareta.lab7.function.Function;
import kareta.lab7.function.MyFunction;

import java.util.Scanner;

/**
 * Created by vitya on 26.04.17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Input a, b, step:");

        int a = console.nextInt();
        int b = console.nextInt();
        double step = console.nextDouble();

        Function function = new MyFunction();
        NumericalMethods methods = new NumericalMethods(function, a, b, step);

        double rectangleResult = methods.rectangle();
        double simpsonResult = methods.simpson();
        double trapezoidResult = methods.trapezoid();

        System.out.println("Rectangle: " + rectangleResult);
        System.out.println("Simpson: " + simpsonResult);
        System.out.println("Trapezoid: " + trapezoidResult);
    }
}
