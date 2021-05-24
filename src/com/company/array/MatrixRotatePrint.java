package com.company.array;

import java.util.ArrayList;

public class MatrixRotatePrint {

    public static void main(String[] args) {
        int[][] a= {{1}};
        ArrayList<Integer> aaa = printMatrix(a);
        for (int i = 0; i < aaa.size(); i++) {
            System.out.println(aaa.get(i));
        }
    }

    //自己写的只能打印方形矩阵
    //原因:只用row,column 来约束行列的边界 那左右上下对称就只能做方形的
    public static ArrayList<Integer> printMatrix(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        int need = (row>column)?row:column;
        ArrayList<Integer> list = new ArrayList<>();
        for(int circle = 0; circle < (need/2+1);circle++){
            for(int i = circle;i < row-circle;i++){
                list.add(matrix[circle][i]);
                System.out.println("1"+"数组下标:"+circle+" "+i);
            }
            for(int j = circle+1;j < column-circle;j++){
                list.add(matrix[j][column-circle-1]);
                //System.out.println(matrix[j][column-circle-1]);
                System.out.println("2"+"数组下标:"+j+" "+(column-circle-1));
            }
            for(int k = row-circle-1;k > circle;k--){
                list.add(matrix[row - circle - 1][k]);
                //System.out.println(matrix[row - circle - 1][k]);
                System.out.println("3"+"数组下标:"+(row - circle - 1)+" "+k);
            }
            for(int l = column-circle-1;l > circle;l--){
                list.add(matrix[l][circle]);
                //System.out.println(matrix[l][circle]);
                System.out.println("4"+"数组下标:"+l+" "+circle);
            }
        }
        return list;
    }

    //添加了 l=left r=right t=top b=bottom 四项约束,向量也可以处理
    public static ArrayList<Integer> printMatrixV2(int[][] matrix){
        ArrayList<Integer> a = new ArrayList<Integer>();
        //if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) a.add(matrix[t][i]) ; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) a.add(matrix[i][r]) ; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) a.add(matrix[b][i]) ; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) a.add(matrix[i][l]) ; // bottom to top.
            if(++l > r) break;
        }
        return a;
    }
}

