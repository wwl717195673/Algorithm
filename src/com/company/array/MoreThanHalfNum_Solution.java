package com.company.array;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
 */
public class MoreThanHalfNum_Solution {

    //哈希法
    public int MoreThanHalfNumV3(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result=0;
        for(int i = 0;i<array.length;i++){
            int count = map.getOrDefault(array[i],0)+1;
            if(count>(array.length/2)){
                result = array[i];
                break;
            }
            map.put(array[i],count);
        }
        return result;
    }

    //排序取中间元素
    //简单不详写了

    //摩尔投票法：抵消法
    public int MoreThanHalfNumV2(int[] array){
        int major = array[0];
        int count = 1;
        for(int i = 1;i<array.length;i++){
            if(count == 0){
                major = array[i];
                count = 1;
            }
            if(major == array[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}
