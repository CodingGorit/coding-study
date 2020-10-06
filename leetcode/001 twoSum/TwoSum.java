package test;

import java.util.Arrays;

/**
 * leetcode 1 twoSum
 */
public class TwoSum {
    public static void main(String[] args) {
        // verify your code
        TwoSum ts = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = ts.twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        boolean flag = false;
        for (int i=0;i<numbers.length;i++) {
            for (int j=1;j<numbers.length;j++) {
                // get answers index
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i+1;
                    res[1] = j+1;
                    flag = true;
                }
            }
            if (flag)
                break;
        }
        return res;
    }
}
