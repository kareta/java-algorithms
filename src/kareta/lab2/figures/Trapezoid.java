package kareta.lab2.figures;

import kareta.lab2.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by vitya on 31.01.17.
 */
public class Trapezoid {
    ArrayList<Point> points;

    private Side longBase;
    private Side shortBase;
    private Side firstLeg;
    private Side secondLeg;

    public Trapezoid(Point... points) {

        this.points = new ArrayList<>(Arrays.asList(points));

        if (!correctSides()) {
            return;
        }

        ArrayList<Side> sides = connectPointsInSides(this.points);

        Pair<Side, Side> bases = getBases(sides);

        if (bases.getLeft().length() > bases.getRight().length()) {
            longBase = bases.getLeft();
            shortBase = bases.getRight();
        } else {
            longBase = bases.getRight();
            shortBase = bases.getLeft();
        }

        Pair<Side, Side> legs = getLegs(sides, bases);

        firstLeg = legs.getLeft();
        secondLeg = legs.getRight();
//        System.out.println("short" + shortBase);
    }

    public Pair<Side, Side> getBases(ArrayList<Side> sides) {
        ArrayList<Pair<Side, Side>> parallelSides = Side.getParallelSides(sides);

        return parallelSides.get(0);
    }

    public Pair<Side, Side> getLegs(ArrayList<Side> sides, Pair<Side, Side> bases) {

        ArrayList<Side> notBases = new ArrayList<>();

        for (Side side : sides) {
            if (!side.equals(bases.getLeft()) && !side.equals(bases.getLeft())) {
                notBases.add(side);
            }
        }

//        System.out.println("Not bases " + notBases.size());

        return new Pair<>(notBases.get(0), notBases.get(1));
    }

    public double getPerimeter() {

        return longBase.length() + shortBase.length() + firstLeg.length() + secondLeg.length();
    }

    public boolean correctSides() {
        if (repeatedPoints(points)) {
            return false;
        }

        ArrayList<Side> sides = connectPointsInSides(points);
        ArrayList<Pair<Side, Side>> parallelSides = Side.getParallelSides(sides);

        return basesAreCorrect(parallelSides);
    }

    public boolean correctTrapezoid() {
        return correctSides();
    }

    public boolean repeatedPoints(ArrayList<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i != j && points.get(i).equals(points.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    public double getArea() {


//        System.out.println("longbase is " + longBase.length());
//        System.out.println("shortbase is " + shortBase.length());
//        System.out.println("firstLeg is " + firstLeg.length());
//        System.out.println("secondLeg is " + secondLeg.length());

        double nominator = square(longBase.length() - shortBase.length()) + square(firstLeg.length()) - square(secondLeg.length());

        double denominator = 2 * (longBase.length() - shortBase.length());

//        System.out.println("Coeficies is " + (square(firstLeg.length()) - square(nominator / denominator)));

        double height = Math.sqrt(
            square(firstLeg.length()) - square(nominator / denominator)
        );


//        System.out.println("nominator is " + nominator);
//        System.out.println("denominator is " + denominator);
//        System.out.println("height is " + height);
//        System.out.println();

        return ((shortBase.length() + longBase.length()) / 2) * height;
    }

    public double trapezoidCoefficient() {
        double nominator = square(longBase.length() - shortBase.length()) + square(firstLeg.length()) - square(secondLeg.length());

        double denominator = 2 * (longBase.length() - shortBase.length());

        return square(firstLeg.length()) - square(nominator / denominator);
    }

    public static double square(double number) {
        return Math.pow(number, 2);
    }

    @Override
    public String toString() {
        return "Points are (" + points.get(0).getX() + " " + points.get(0).getY()
                + ") (" + points.get(1).getX() + " " + points.get(1).getY()
                + ") (" + points.get(2).getX() + " " + points.get(2).getY()
                + ") (" + points.get(3).getX() + " " + points.get(3).getY() + ")"
                + " Perimeter is " + String.format("%.2f", getPerimeter()) + " "
                + " Area is " + String.format("%.2f", getArea());
    }

    public static Trapezoid getRandomTrapezoid() {
        Random random = new Random();
        int scale = 1000;

        Point pointA = null;
        Point pointB = null;
        Point pointC = null;
        Point pointD = null;

        Trapezoid trapezoid = null;
        boolean trapezoidCorrect = false;

//        do {
            pointA = new Point(
                Math.abs(random.nextInt()) % scale + 1,
                Math.abs(random.nextInt()) % scale + 1
            );

            pointB = new Point(
                Math.abs(random.nextInt()) % scale + 1,
                Math.abs(random.nextInt()) % scale + 1
            );

            pointC = new Point(
                Math.abs(random.nextInt()) % scale + 1,
                Math.abs(random.nextInt()) % scale + 1
            );

            pointD = new Point(
                Math.abs(random.nextInt()) % scale + 1,
                Math.abs(random.nextInt()) % scale + 1
            );

            trapezoid = new Trapezoid(pointA, pointB, pointC, pointD);
            return  trapezoid;
//            try {
//                trapezoidCorrect = trapezoid.correctTrapezoid();
//                if (trapezoidCorrect && trapezoid.trapezoidCoefficient() <= 0) {
//                    trapezoidCorrect = false;
//                }
//            } catch (Exception e) {
//                trapezoidCorrect = false;
//            }
//
//        } while (!trapezoidCorrect);
//
//        return trapezoid;
    }

    public static boolean onePairOfBases(ArrayList<Pair<Side, Side>> bases) {
        return bases.size() == 1;
    }

    public static boolean basesLengthIsCorrect(Pair<Side, Side> bases) {
        return bases.getLeft().length() != bases.getRight().length();
    }

    public static boolean basesAreCorrect(ArrayList<Pair<Side, Side>> bases) {
        return onePairOfBases(bases) && basesLengthIsCorrect(bases.get(0));
    }

    public static ArrayList<Side> connectPointsInSides(ArrayList<Point> points) {

        ArrayList<Side> sides = new ArrayList<Side>(4);

        for (int i = 0; i < 3; i++) {
            sides.add(new Side(points.get(i), points.get(i + 1)));
        }

        sides.add(new Side(points.get(0), points.get(3)));

        return sides;
    }
}
