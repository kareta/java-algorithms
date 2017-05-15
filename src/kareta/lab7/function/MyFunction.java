package kareta.lab7.function;

/**
 * Created by vitya on 26.04.17.
 */
public class MyFunction implements Function {
    @Override
    public double run(double x) {
        return Math.exp(x) / Math.sqrt(1 + x * x + x);
    }
}
