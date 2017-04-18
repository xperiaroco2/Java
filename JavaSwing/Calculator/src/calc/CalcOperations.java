package calc;

/**
 * Created by h on 18.04.2017.
 */
public class CalcOperations {

    public static double add(double a, double b){
        return a + b;
    }

    public static double divide(double a,double b){
        try {
            return a / b;
        }catch (ArithmeticException e){
            return 0;
        }
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    }
