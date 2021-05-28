package com.company.Tree;

import java.util.Stack;

public class DepthOfTree {
    //前序和中序做不了
    //因为我们是用栈的最大高度来当作最大深度,前序中序,根结点在计算后被弹走了,不能压在栈底,无法计算最大高度

    //后序遍历迭代法
    public int maxDepth(TreeNode root) {
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right.equals(pre)){
                if(stack.size()+1>max)    max = stack.size()+1;
                pre = root;
                root = null;
            }else{
                root = root.right;
                stack.push(root);
            }
        }
        return max;
    }
}
