package com.company.DP;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
public class LeastSeqSum {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        //动态规划方程存储用原来的数组进行
        for(int i = 1;i < array.length; i++){
            array[i] += Math.max(array[i-1],0);
            res = Math.max(array[i],res);
        }
        return res;
    }
}
