package com.company.array;

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
//保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。

public class pow {
    public static void main(String[] args) {
        System.out.println(powV2(2,5));
    }

    //显而易见:暴力方法
    public static double powV1(double base, int exponent){
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ret = 1.0;
        for (int i=0; i<exponent; ++i) ret *= base;
        return ret;
    }

    //递归快速幂
    //将原来的幂拆分成2*2*2*...*2,可以将循环次数调到O(logN),但是也需要O(logN)的递归栈来保存
    public static double powV2(double base,int exponent){
        if (exponent<0){
            return powV2(1 /base,-exponent);
        }
        if (exponent == 0){ return 1;}
        double ret = powV2(base,exponent/2);
        if ((exponent & 1) == 1){
            //奇次幂
            return ret * ret * base;
        }else {
            //偶次幂
            return ret * ret;
        }
    }

    //迭代快速幂
    //经原来的幂分解为二进制:把exp看做二进制,和1做与运算,如果结果为真,证明exp在该二进制位上为1;
    public static double powV3(double base,int exponent){
        if (exponent<0){
            base = 1/base;
            exponent = -exponent;
        }
        double x = base;
        double res = 1.0;
        while(exponent!=0){
            if ((exponent & 1)==1){
                res *= x;
            }
            //幂位上升,x也应该double
            x *= x;
            exponent >>= 1;
        }
        return res;
    }
}
