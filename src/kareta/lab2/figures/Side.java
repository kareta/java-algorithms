package kareta.lab2.figures;

import kareta.lab2.Pair;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vitya on 06.02.17.
 */
public class Side {
    public Point firstPoint;
    public Point secondPoint;

    public Side(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public double length() {
        return firstPoint.distance(secondPoint);
    }

    public static boolean areParallel(Side firstSide, Side secondSide)
    {

        if (firstSide.firstPoint.equals(secondSide.firstPoint) || firstSide.firstPoint.equals(secondSide.secondPoint) || firstSide.secondPoint.equals(secondSide.firstPoint) || firstSide.secondPoint.equals(secondSide.secondPoint))
            return false;

        double firstSlope = -9999;

        if (firstSide.firstPoint.x != firstSide.secondPoint.x) {
            firstSlope = (firstSide.firstPoint.y - firstSide.secondPoint.y)
                    / (double)(firstSide.firstPoint.x - firstSide.secondPoint.x);
        }

        double secondSlope = -9999;

        if (secondSide.firstPoint.x != secondSide.secondPoint.x) {
            secondSlope = (secondSide.firstPoint.y - secondSide.secondPoint.y)
                    / (double)(secondSide.firstPoint.x - secondSide.secondPoint.x);
        }

        return firstSlope == secondSlope;
    }

    public static ArrayList<Pair<Side, Side>> getParallelSides(ArrayList<Side> sides) {
        ArrayList<Pair<Side, Side>> listOfParallelSides = new ArrayList<>();

        for (int i = 0; i < sides.size(); i++) {
            for (int j = 0; j < sides.size(); j++) {

                Pair<Side, Side> parallelSides = null;

                if (i != j && areParallel(sides.get(i), sides.get(j))) {
                    parallelSides = new Pair<Side, Side>(sides.get(i), sides.get(j));

                    if (!listOfParallelSides.contains(parallelSides)) {
                        listOfParallelSides.add(parallelSides);
                    }
                }
            }
        }


        return listOfParallelSides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Side side = (Side) o;

        if (!firstPoint.equals(side.firstPoint)) return false;
        return secondPoint.equals(side.secondPoint);

    }

    @Override
    public int hashCode() {
        int result = firstPoint.hashCode();
        result = 31 * result + secondPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstPoint + " " + secondPoint + "\n";
    }
}
