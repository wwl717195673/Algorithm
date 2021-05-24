package com.company.DP;

//题目描述
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。


public class JumpSteps {
    public static void main(String[] args) {
        int target = 46;
        /*
        方式一的输出:
        System.out.println(jumpV1(10));
         */
        /*
        方式二的输出:
        int[] mem = new int[target+1];
        for (int i = 0; i <= target; i++) {
            mem[i] = -1;
        }
        System.out.println(jumpV2(target,mem));*/

        System.out.println(jumpV3(45));
    }

    //方法一:递归
    public static int jumpV1(int target){
        if (target <= 1) return 1;
        else return jumpV1(target - 1)+jumpV1(target - 2);
    }

    //方法二:记忆搜索
    //利用数组来记录之前递归计算过的结果
    public static int jumpV2(int target,int[] mem){
        if (target <= 1) return 1;
        if (mem[target] != -1){
            return mem[target];
        }else {
            return mem[target] = jumpV2(target-1,mem) + jumpV2(target-2,mem);
        }
    }

    //方法三:动态规划
    //上面两种方法都是从上往下倒推,动归从下往上计算
    public static int jumpV3(int target){
        int dp[] = new int[target];
        dp[0] = dp[1] = 1;
        for (int i=2;i<target;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target-1];
    }
}
