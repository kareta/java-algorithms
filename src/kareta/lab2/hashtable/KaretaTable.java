package kareta.lab2.hashtable;

import kareta.lab2.figures.Trapezoid;

/**
 * Created by vitya on 05.02.17.
 */
public class KaretaTable {

    private HashEntry[] table;

    public KaretaTable (int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Size is only allowed to be a positive integer.");
        }

        table = new HashEntry[size];
    }

    public int hash(double key) {
        double fractionPart = (key * 0.618) % 1;
        return (int) (fractionPart * table.length);
    }

    public Trapezoid get(double key) {
        int hash = hash(key);
        int i = 0;

        while (i < table.length) {
            hash = (hash + 1) % table.length;
            i++;

            if (table[hash] != null && table[hash].getKey() == key) {
                return table[hash].getValue();
            }
        }

        return null;
    }

    public boolean put(double key, Trapezoid value) {
        int hash = hash(key);
        int i = 0;

        if (table[hash] != null) {
            return false;
        }

//        while (table[hash] != null && table[hash].getKey() != key) {
//            hash = (hash + 1) % table.length;
//            i++;
//
//            if (i == table.length) {
//                return false;
//            }
//        }

        table[hash] = new HashEntry(key, value);

        return true;
    }

    public Trapezoid remove(double key) {
        int hash = hash(key);
        int i = 0;

        while (i < table.length) {
            hash = (hash + 1) % table.length;
            i++;

            if (table[hash] != null && table[hash].getKey() == key) {
                Trapezoid trapezoid = table[hash].getValue();
                table[hash] = null;
                return trapezoid;
            }
        }

        return null;
    }

    public boolean removeRange(double lowestKey, double highestKey) {

        boolean removed = false;

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) {
                continue;
            }

            boolean isInRange = table[i].getKey() >= lowestKey && table[i].getKey() <= highestKey;

            if (isInRange) {
                table[i] = null;
                removed = true;
            }
        }

        return removed;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("Table is \n");

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) {
                builder.append(
                        i + " is empty\n"
                );
            }

            if (table[i] != null) {
                builder.append(
                    i + " key is " + String.format("%.2f", table[i].getKey())
                    + ": " + table[i].getValue() + "\n"
                );
            }
        }

        return builder.toString();
    }


}


