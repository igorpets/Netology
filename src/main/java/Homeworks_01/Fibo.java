package Homeworks_01;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibo {
    Map<Integer, BigInteger> map = new HashMap<>();

    private BigInteger calcFibo(int arg) throws IllegalAccessException {
        if (arg < 1) throw new IllegalAccessException();
        if (arg <= 2) return BigInteger.ONE;
        return fibo(arg - 1).add(fibo(arg - 2));
    }

    private BigInteger fibo(int arg) throws IllegalAccessException {
        BigInteger value = map.get(arg);
        if (value == null) {
            value = calcFibo(arg);
            map.put(arg, value);
        }
        return value;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Fibo fibo = new Fibo();
        System.out.println(fibo.fibo(100));
    }
}
