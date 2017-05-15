package kareta.lab6.hashtable;

/**
 * Created by vitya on 05.02.17.
 */
public class HashEntry {
    private int key;
    private String value;

    HashEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}