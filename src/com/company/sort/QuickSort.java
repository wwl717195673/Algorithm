package com.company.sort;

import java.util.Random;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2,3,5,6,8,5,3};
        quickSort(arr);
        for (int i:arr){
            System.out.print(i+",");
        }
    }

    public static int getPivot(int left, int right){
        return new Random().nextInt(right-left)+left;
    }

    public static void quickSort(int[] nums){
        if (nums == null || nums.length==0)
            return;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        stack.push(nums.length-1);
        while (!stack.empty()){
            int right = stack.pop();
            int left = stack.pop();
            if (right<left){
                continue;
            }
            int dp = partition(nums,left,right);
            if (left<dp-1){
                stack.push(left);
                stack.push(dp-1);
            }
            if (dp+1<right){
                stack.push(dp+1);
                stack.push(right);
            }
        }
    }

    public static int partition(int[] arr, int left, int right){
        int k = arr[getPivot(left, right)];
        while(left < right){
            while (left < right && arr[right]>= k ){
                right--;
            }
            if (left < right){
                arr[left++]=arr[right];
            }
            while (left<right && arr[left] <= k){
                left++;
            }
            if (left<right){
                arr[right--]=arr[left];
            }
        }
        arr[left]=k;
        return left;
    }
}
