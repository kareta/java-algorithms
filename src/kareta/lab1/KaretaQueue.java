package kareta.lab1;


public class KaretaQueue {

    private Integer[] internalArray;
    private int lastIndex = 0;

    public KaretaQueue(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException("Size is only allowed to be a positive integer.");
        }

        this.internalArray = new Integer[size];
    }

    public boolean offer(Integer element) {
        if (lastIndex == internalArray.length - 1) {
            return false;
        }

        internalArray[lastIndex] = element;
        lastIndex++;

        return true;
    }

    public Integer remove() {
        if (lastIndex == 0) {
            return null;
        }

        Integer removedElement = internalArray[0];

        for (int i = 0; i < internalArray.length - 1; i++) {
            internalArray[i] = internalArray[i + 1];
        }

        internalArray[lastIndex] = null;
        lastIndex--;

        return removedElement;
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == internalArray.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < internalArray.length; i++) {
            if (internalArray[i] == null) {
                break;
            }

            builder.append(internalArray[i]);
            builder.append(" ");
        }

        return builder.toString();
    }
}
