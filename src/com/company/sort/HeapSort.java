package com.company.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,7,3,5,0,1,36,2};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //每次局部的调整
    //小轮子向下调整
    public static void heapify(int[] arr,int parent,int length){
        int temp = arr[parent];
        //从零开始的编号
        int child = parent*2+1;
        while(child < length){
            //右节点比左节点大，那我们就选取右节点往上调
            if (child + 1 <length && arr[child+1]>arr[child]){
                child++;
            }
            if (arr[child]<temp)
                break;
            arr[parent] = arr[child];

            //继续向下
            parent = child;
            child = 2*parent+1;
        }
        //把原来的值向下放
        arr[parent] = temp;
    }

    //大轮子从右向左，从下至上选取节点调整
    public static void sort(int[] arr){
        for (int i = arr.length/2;i>=0;i--){
            heapify(arr,i,arr.length);
        }

        for (int i = arr.length-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //为什么把第0个元素作为父节点进行调整？
            //因为此时第0个元素不满足小顶堆了
            heapify(arr,0,i);
        }
    }

}
