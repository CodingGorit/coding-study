package cn.gorit.jzoffer;

/**
 *斐波那契数列
 */
public class JZ7 {
    public int Fibonacci(int n) {
        int[] fib = new int[40];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2;i<=n;i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
