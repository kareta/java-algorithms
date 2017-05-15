package kareta.lab6;

/**
 * Created by vitya on 12.05.17.
 */
public class Stopwatch {
    private long startTime = System.nanoTime();

    public void start() {
        startTime = System.nanoTime();
    }

    public double time() {
        return (System.nanoTime() - startTime) * 0.000000001;
    }
}
