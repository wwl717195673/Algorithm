package com.company.array;

//输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示
public class Decimal2Binary {

    public static void main(String[] args) {
        System.out.println(NumberOf1(-5));
    }


    //自己写的常规思路 处理不了int的下界,因为int的下界无法去反
    public static int NumberOf1(int n) {
        boolean flag = false;
        if(n<0) flag = true;
        System.out.println(flag);
        int[] s = new int[100];
        int count = 0;
        int num = 0;
        System.out.println(n);
        if(flag){
            n = -1*n;
            System.out.println(1);
        }
        System.out.println(n);

        while(n!=0){
            s[count] = n%2;
            count++;
            n=n/2;
        }
        while(count>=0){
            if(!flag && s[count]==1){
                num++;
            }
            if(flag && s[count]==0){
                num++;
            }
            count--;
        }
        return num;
    }

    //解法思路:如果一个整数不为0，那么这个整数至少有一位是1。
    // 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
    public static int NumberOf2(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    //让一个数0x01从右向左与val的每一位进行&操作来判断
    public static int Numberof3(int n){
            int ans = 0;
            int mark =0x01;
            while(mark != 0){
                if((mark & n)!=0){
                    ++ans;
                }
                mark <<=1;

            }
            return ans;
        }
}
