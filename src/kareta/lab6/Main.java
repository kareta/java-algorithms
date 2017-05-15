package kareta.lab6;


import kareta.lab6.hashtable.KaretaTable;

import java.util.Random;

/**
 * Created by vitya on 26.04.17.
 */
public class Main {

    public static void search(int n, int searchedNumber) {

        KaretaTable table = new KaretaTable(n);
        Random random = new Random();


        for (int i = 0; i < n; i++) {
            int number = random.nextInt() * random.nextInt();
            number = Math.abs(number) % n;
            table.put(number, "Some" + number);
        }

        if (n == 100) {
            System.out.println(table);
        }

        Stopwatch stopwatch = new Stopwatch();
        System.out.println("n=" + n + " " + table.get(searchedNumber));
        System.out.println(String.format("%f", stopwatch.time()));
    }

    public static void main(String[] args) {
        search(100, 42);
        search(10000, 4234);
        search(1000000, 42334);
    }
}
