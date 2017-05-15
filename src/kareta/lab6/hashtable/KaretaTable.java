package kareta.lab6.hashtable;

/**
 * Created by vitya on 05.02.17.
 */
public class KaretaTable {

    private HashEntry[] table;
    private int countInTable;

    public KaretaTable (int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Size is only allowed to be a positive integer.");
        }

        table = new HashEntry[size];
    }

    public int hash(int key) {
        double fractionPart = (key * 0.618) % 1;
        return (int) (fractionPart * table.length);
    }

    public String get(int key) {
        int hash = hash(key);
        int i = 1;
        int foundElementsCount = 0;

        while (foundElementsCount < countInTable) {
            hash = (hash + i * i) % table.length;
            hash = Math.abs(hash);
            i++;

            if (table[hash] != null) {
                foundElementsCount++;
            }

            if (table[hash] != null && table[hash].getKey() == key) {
                return table[hash].getValue();
            }
        }

        return null;
    }

    public boolean put(int key, String value) {

        if (countInTable == table.length) {
            return false;
        }

        int hash = hash(key);
        int i = 1;
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + i * i) % table.length;
            hash = Math.abs(hash);
            i++;
        }

        table[hash] = new HashEntry(key, value);
        countInTable++;
        return true;
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
                    i + " key is " + String.format("%d", table[i].getKey())
                    + ": " + table[i].getValue() + "\n"
                );
            }
        }

        return builder.toString();
    }


}


