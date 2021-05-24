package com.company.array;

public class MatrixFind {
    public static void main(String[] args) {
        int[][] arr = {  {1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        System.out.println(MFind(10,arr));
    }

    //根据有序矩阵规律进行查找
    public static boolean MFind(int target,int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        //从右上角开始遍历
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if (arr[i][j]==target) return true;
                if (arr[i][j]>target) continue;
                if (arr[i][j]<target) break;
            }
        }
        return false;
    }

    //二分逐层查找
    public static boolean Find(int target, int[][] array){
        int m = array.length;
        for(int i = 0;i < m;i++){
            if(twoFind(target,array[i])) return true;
        }
        return false;
    }
    public static boolean twoFind(int t, int[] a){
        int high = a.length-1;
        int low = 0;
        int mid = (high+low)/2;
        while(low <= high){
            mid = (high+low)/2;
            if(t > a[mid]){
                low = mid+1;
            }else if(t < a[mid]){
                high = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
