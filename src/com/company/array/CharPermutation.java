package com.company.array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class CharPermutation {
    ArrayList<String> arr = new ArrayList<>();
    char[] c;
    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        Collections.sort(arr);
        return arr;
    }
    public void dfs(int x){
        if(x==c.length-1){
            arr.add(new String(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x;i<c.length;i++){
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(x,i);
            dfs(x+1);
            swap(x,i);
        }
    }
    public void swap(int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
