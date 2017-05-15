package kareta.lab2.hashtable;

import kareta.lab2.figures.Trapezoid;

/**
 * Created by vitya on 05.02.17.
 */
public class HashEntry {
    private double key;
    private Trapezoid value;

    HashEntry(double key, Trapezoid value) {
        this.key = key;
        this.value = value;
    }

    public double getKey() {
        return key;
    }

    public Trapezoid getValue() {
        return value;
    }
}