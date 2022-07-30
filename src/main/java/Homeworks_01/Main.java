package Homeworks_01;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("Hello programming! Улыбающееся лицо :)");

        double amount = 1.00000005D;
        double avalue = 0.00000004D;
        double result =  amount - avalue;
        print_result(result);

        //double positive_infinity = 12.0D / 0;
        //double negative_infinity = -15.0D / 0;
        //System.out.println(positive_infinity + negative_infinity);
    }

    private static void print_result(double result) {
        System.out.println(result);
    }
}
