package kareta.lab1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by vitya on 25.01.17.
 */

public class KaretaList implements Iterable<String> {

    private KaretaNode head, tail;

    public boolean isEmpty() {
        return tail == null && head == null;
    }

    public String get(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is incorrect.");
        }

        int i = 0;

        for (String data : this) {
            if (index == i) {
                return data;
            }

            i++;
        }

        throw new IndexOutOfBoundsException("Index " + index + " is incorrect.");
    }

    public boolean insert(int index, String value) {

        if (!isInteger(value, 10)) {
            return false;
        }

        if (index < 0) {
            return false;
        }

        KaretaNode current = head;


        if (index == 0) {
            return offerFirst(value);
        }

        int i = 0;


        while (current != null) {
            if (i == index) {
                KaretaNode node = new KaretaNode(value, current, current.previous);

                current.previous = node;
                node.previous.next = node;
                return true;
            }
            i++;

            current = current.next;
        }

        if (i == index) {
            return offerLast(value);
        }

        return false;
    }

    public boolean offerFirst(String data) {

        if (!isInteger(data, 10)) {
            return false;
        }

        KaretaNode node = new KaretaNode(data, head, null);

        if (head != null) {
            head.previous = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }

        return true;
    }

    public boolean offerLast(String data) {

        if (!isInteger(data, 10)) {
            return false;
        }

        KaretaNode node = new KaretaNode(data, null, tail);

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = node;
        }

        return true;
    }

    public String removeFirst() {

        if (isEmpty()) {
            return null;
        }

        String data = head.data;

        if (tail == head){
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        return data;
    }

    public String removeLast() {

        if (isEmpty()) {
            return null;
        }

        String data = tail.data;

        if (tail == head){
            tail  = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        return data;
    }

    public String remove(String value) {
        KaretaNode node = head;

        while (node != null) {
            if (Objects.equals(node.data, value)) {
                String removed = node.data;

                node.previous.next = node.next;
                node.next.previous = node.previous;
                return removed;
            }

            node = node.next;
        }

        return null;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (String number : this) {
            builder.append(number);
            builder.append(" ");
        }

        return builder.toString();
    }

    public static boolean isInteger(String s, int radix) {

        if (s.isEmpty()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }

            if(Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return new KaretaIterator();
    }

    public Iterator<String> reverseIterator() {
        return new ReverseKaretaIterator();
    }

    private class KaretaNode {

        String data;

        KaretaNode previous, next;

        KaretaNode(String data, KaretaNode next, KaretaNode previous) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private class KaretaIterator implements Iterator<String> {

        private KaretaNode current = head;
        private KaretaNode returnedNode = current;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public String next() {

            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            returnedNode = current;
            String data = current.data;
            current = current.next;

            return data;
        }

        @Override
        public void remove() {
            if (returnedNode == head) {
                removeFirst();
                return;
            }

            if (returnedNode == tail) {
                removeLast();
                return;
            }

            if (returnedNode != null) {
                returnedNode.previous.next = returnedNode.next;
                returnedNode.next.previous = returnedNode.previous;
            }
        }
    }

    private class ReverseKaretaIterator implements Iterator<String> {

        private KaretaNode current = tail;
        private KaretaNode returnedNode = current;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public String next() {
            if(!hasNext()) throw new NoSuchElementException();

            returnedNode = current;

            String t = current.data;
            current = current.previous;
            return t;
        }

        @Override
        public void remove() {
            if (current == head) {
                removeFirst();
                return;
            }

            if (current == tail) {
                removeLast();
                return;
            }

            if (current != null) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        }
    }
}
