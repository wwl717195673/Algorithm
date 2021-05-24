package com.company.array;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class ReorderArrayByOdd {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7};
        a=reOrderArrayV2(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    //不讲究相对位置的
    public int[] reOrderArray (int[] array) {
        // write code here
        int p=0;
        boolean pFlag=true,qFlag=true;
        int q=array.length/2;
        while(q != array.length){
            if(array[p]%2==1) p++;
            else pFlag = false;
            if(array[q]%2==0) q++;
            else qFlag = false;
            if(!pFlag && !qFlag){
                int temp = array[p];
                array[p]=array[q];
                array[q]=temp;
                pFlag = true;
                p++;
                qFlag = true;
                q++;
            }
        }
        return array;
    }

    //将就相对位置的
    //利用冒泡排序的思想,将比大小改为看是否为偶数
    //超时
    public static int[] reOrderArrayV2(int[] array){
        for (int i = 0;i< array.length-1;i++)
            for (int j = 0;j<array.length-i-1;j++){
                if (array[j]%2 == 0 && array[j+1]%2 == 1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        return array;
    }

    //
    public static int[] reOrderArrayV3(int[] array){
        int ji=-1;//记录上一个奇数位置，-1兼容开头偶数情况
        for (int i = 0; i < array.length; i++) {
            if((array[i]&1)==1) {
                ji+=1;
                //两个奇数间的偶数后移，奇数一道上一个奇数后面
                int tmp=array[i];
                for (int j = i; j > ji; j--) {
                    array[j]=array[j-1];
                }
                array[ji]=tmp;

            }
        }
        return array;
    }
}
