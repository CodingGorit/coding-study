package cn.gorit.jzoffer;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n) = f(n-1) + f(n-2)...+f(1)
 * f(n-1))=f(n-2)+f(n-3)..+f(1)
 * f(n)=2f(n-1)
 * f(0) = 0
 * f(1) = 1
 * f(2) = 2
 * f(3) = 4
 * f(4) = 8
 * 递推公式：
 */
public class JZ9 {
    public int JumpFloorII(int target) {
        return 1<<target-1;
    }

    public static void main(String[] args) {
        System.out.println(1>>3);
    }
}
