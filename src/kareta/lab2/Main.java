package kareta.lab2;


import kareta.lab2.figures.Trapezoid;
import kareta.lab2.hashtable.KaretaTable;

import java.awt.*;

/**
 * Created by vitya on 30.01.17.
 */

//Линейное зондирование
// Квадратичное зондирование
    //Двойное зондирование
    //Идеальное зондирование
    //Multiplying ind = 5 * 0.618 = 3.09 = 0.09
    //0.09 * 10 = 0.9 index is 0 after casting
public class Main {
    public static void main(String[] args) {
        KaretaTable table = new KaretaTable(100000);

        Trapezoid trapezoidToGet = new Trapezoid(
            new Point(1, 1), new Point(2, 4),
            new Point(4, 4), new Point(6, 1)
        );

//        System.out.println(trapezoidToGet.correctTrapezoid());

//        System.out.println(trapezoidToGet.getPerimeter());

        System.out.println();

        table.put(trapezoidToGet.getPerimeter(), trapezoidToGet);

//        System.out.println(table.toString());

        for (int i = 0; i < 10000; i++) {
            Trapezoid trapezoid = Trapezoid.getRandomTrapezoid();
            table.put(trapezoid.getPerimeter(), trapezoid);
        }

        System.out.println("Put over size:");
        System.out.println(table.toString());

    }
}
