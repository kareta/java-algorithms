package kareta.lab1;


import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        KaretaList list = new KaretaList();

        System.out.println("is empty " + list.isEmpty());

        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int n = rand.nextInt(50) + 1;
            list.offerFirst(n + "");

        }

        System.out.println("list is " + list.toString());
        list.remove("5");
        System.out.println("After removing 5, " + list.toString());
        list.insert(21, "1111");
        System.out.println("After inserting 1111, " + list.toString());
        list.offerFirst("-30");
        list.offerLast("-10");
        System.out.println("After inserting -30 -10, " + list.toString());
        System.out.println("Is empty, " + list.isEmpty());
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing -30 -10, " + list.toString());


        Iterator<String> i = list.iterator();

        while (i.hasNext()) {
            String number = i.next();

            if (Integer.parseInt(number) % 2 == 0) {
                i.remove();
            }
        }

        System.out.println("Removed even numbers, " + list.toString());

        KaretaQueue queue = new KaretaQueue(20);

        for (String number : list) {
            queue.offer(Integer.parseInt(number));
        }

        System.out.println("Queue is " + queue.toString());



        System.out.println("First in queue " + queue.remove());
        System.out.println("Queue after removing " + queue.toString());


    }
}
