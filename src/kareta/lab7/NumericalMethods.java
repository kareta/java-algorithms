package kareta.lab7;

import kareta.lab7.function.Function;


/**
 * Created by vitya on 26.04.17.
 */
public class NumericalMethods {

    private Function function;

    private int a;
    private int b;
    private double step;

    public NumericalMethods(Function function, int a, int b, double step) {
        this.function = function;

        this.a = a;
        this.b = b;
        this.step = step;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    double rectangle() {
        double result = 0;
        int segmentsNumber = (int) ((b - a) / step);
        for (int i = 0; i < segmentsNumber; i++) {
            result += function.run(a + step * (i + 0.5));
        }
        return result * step;
    }

    double simpson() {
        int segmentsNumber = (int) ((b - a) / step);
        double result = (function.run(a) + function.run(b)) * 0.5;
        
        for (int i = 1; i <= (segmentsNumber - 1); i++) {
            double temporary = a + step * i;
            double temporaryIMinusOne = a + step * (i - 1);
            result += function.run(temporary) 
                    + 2 * function.run((temporaryIMinusOne + temporary) / 2);
        }
        
        double temporaryLast = a + step * segmentsNumber;
        double temporarySecondLoopLast = a + step * (segmentsNumber - 1);
        
        result += 2 * function.run((temporarySecondLoopLast + temporaryLast) / 2);
        
        return result * (step / 3.0);
    }

    double trapezoid() {
        int segmentsNumber = (int) ((b - a) / step);
        double sum = 0;

        if (0 == segmentsNumber){
            return sum;
        }

        double temporaryStep = (b - a) / (1.0 * segmentsNumber);

        for (int i = 1; i < segmentsNumber; i++) {
            sum += function.run(a + i * temporaryStep);
        }

        sum += (function.run(a) + function.run(b)) / 2;
        sum *= temporaryStep;

        return sum;
    }
}
