package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
* 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
* 注意：答案中不可以包含重复的三元组。
*
* */
public class SumOfThree {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};

        List<List<Integer>> list = threeSum(nums);

        System.out.println(list.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0;i <= nums.length-3;i++){
            for (int j = i+1; j <= nums.length-2;j++){
                for (int k = j+1;k <=nums.length-1;k++){
                    System.out.println(nums[i]+"+"+nums[j]+"+"+nums[k]);
                    Integer[] setTemp = check(nums[i],nums[j],nums[k]);

                    if (setTemp != null){
                        list.add(Arrays.asList(setTemp));
                    }
                    if (check4Cut(nums,i,j,k)){
                        return list;
                    }
                }
            }
        }
        return list;
    }
    public static Integer[] check(int a, int b, int c){
        if ((a+b)+c == 0){
            Integer[] resultSet = {a,b,c};
            return resultSet;
        }else {
            return null;
        }
    }

    public static boolean check4Cut(int[] s, int i, int j, int k){
        if (i+1==j && j+1==k && s[i]+s[k]+s[j]>0){
            return true;
        }else {
            return false;
        }
    }

}
