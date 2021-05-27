package com.company.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的K个数
 */

public class GetKLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> a = GetLeastNumbers_SolutionV2(arr,4);
        //结果
        System.out.println("结果");
        for (Integer i:a){
            System.out.print(i+" ");
        }
    }

    //冒泡排序第K次跳出
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length) return new ArrayList<Integer>();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0;i<k;i++){
            for(int j = 0 ;j<input.length-i-1;j++){
                if(input[j]<input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            arr.add(input[input.length-1-i]);
        }
        return arr;
    }

    //堆排序
    public static ArrayList<Integer> GetLeastNumbers_SolutionV2(int [] input, int k){
        if(k > input.length) return new ArrayList<Integer>();

        //使用优先队列来模拟堆排序
        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                 return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < k; i++) {
            heap.add(input[i]);
        }
        System.out.println("初始：");
        for(Integer i:heap){
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i = k;i < input.length;i++){
            if (input[i]<heap.peek()){
                heap.poll();
                heap.add(input[i]);
            }
            System.out.println("第"+i+"次");
            for(Integer s:heap){
                System.out.print(s+" ");
            }
        }
        return new ArrayList<Integer>(heap);
    }
}
