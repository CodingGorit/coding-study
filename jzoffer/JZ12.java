package cn.gorit.jzoffer;

/**
 * 数值中整数的平方
 */
public class JZ12 {
    public double Power(double base, int exponent) {
//        return Math.pow(base,exponent);
        if (exponent < 0) {
            exponent *= -1;
            base = 1.0/base;
        }
        double res = 1.0;
        for (int i=1;i<=exponent;i++) {
            res*=base;
        }
        return res;
    }
}
