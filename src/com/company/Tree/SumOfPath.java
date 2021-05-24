package com.company.Tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
* */
public class SumOfPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        find(root,target);
        return result;
    }
    public void find(TreeNode n,int target){
        if(n == null) return;
        target -= n.val;
        path.add(n.val);
        if(target ==0 && n.left == null && n.right == null){
            result.add(new ArrayList<Integer>(path));
        }
        //代码剪枝,如果target小于零,我们就不往下计算了
        if(target >=0){
            find(n.left,target);
            find(n.right,target);
        }
        path.remove(path.size()-1);
    }
}
