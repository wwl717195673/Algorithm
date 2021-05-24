package com.company.Tree;

public class VerifySquenceOfBST {
    public static void main(String[] args) {

    }
    public boolean VerifySquenceOfBSTDo(int [] sequence) {
        if (sequence == null || sequence.length == 0)     return false;
        return Check(sequence,0,sequence.length-1);
    }

    public boolean Check(int[] s,int low,int high){
        if(low >= high) return true;
        //k指向远离high的边界值
        int k = high;
        for(;k>low;k--){
            if(s[high]>s[k])    break;
        }
        for(int j = k-1;j>=low;j--){
            if(s[high]<s[j])    return false;
        }
        return Check(s,low,k) && Check(s,k+1,high);
    }
}
