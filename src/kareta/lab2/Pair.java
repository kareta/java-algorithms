package kareta.lab2;

/**
 * Created by vitya on 27.02.17.
 */
public class Pair<L,R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

    @Override
    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;

        boolean directEquals = this.left.equals(pairo.getLeft())
            && this.right.equals(pairo.getRight());

        boolean reversedEquals = this.left.equals(pairo.getRight())
                && this.right.equals(pairo.getLeft());

        return directEquals || reversedEquals;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
