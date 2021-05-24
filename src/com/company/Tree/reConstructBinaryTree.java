package com.company.Tree;
import java.util.Arrays;
//前序和中序重建二叉树 NLR LNR

public class reConstructBinaryTree {
    public static void main(String[] args) {

    }

    //递归法
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 && in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i < in.length;i++){
            if(pre[0]==in[i]){
                reConstructBinaryTree(Arrays.copyOfRange(pre,i,i+1),Arrays.copyOfRange(in,0,i+1));
                reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }

    //迭代法
//    public TreeNode reConstructBinaryTreeV2(int[] pre,int[] in){
//
//    }

}
