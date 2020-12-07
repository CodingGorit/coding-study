package cn.gorit.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计数质数 （求质数）
 */
public class Leetcode204 {
    public int countPrimes(int n) {
		// First method    	
//        if (n==2) return 1;
//        int t = 0;
//        for (int i=2;i<n;i++) {
//            t += isPrimes(i) ? 1:0;
//        }
//        return t;

        // Second method
//        int[] isPrime = new int[n];
//        Arrays.fill(isPrime,1);
//        int ans = 0;
//        for (int i=2; i<n;++i) {
//            if (isPrime[i] == 1) {
//                ans+=1;
//                if ((long)i*i<n) {
//                    for (int j=i*i;j<n;j+=i) {
//                        isPrime[j] = 0;
//                    }
//                }
//                System.out.print(i+" ");
//            }
//        }
//        return ans;

        // Third method 线性筛
        List<Integer> primes = new ArrayList<Integer>(); // 存储所有的素数集合
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes,1);
        for (int i=2;i<n;i++) {
            if (isPrimes[i] == 1) {
                primes.add(i);
            }
            for (int j=0;j<primes.size() && i*primes.get(j)<n;++j ) {
                isPrimes[i*primes.get(j)]=0;
                if (i*primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    /**
     * Judge the element is a prime
      * @param x
     * @return boolean
     */
    public static boolean isPrimes(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode204 l = new Leetcode204();
        int res = l.countPrimes(10000);
        System.out.println("\n素数个数："+res);
    }
}
