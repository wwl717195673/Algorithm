package com.company.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 二叉树的镜像
 */
public class Mirror {

    //递归解决
    public static TreeNode MirrorTree(TreeNode pRoot){
        if(pRoot == null){
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = MirrorTree(pRoot.right);
        pRoot.right = MirrorTree(temp);
        return pRoot;
    }

    //BFS
    public static TreeNode MirrorTreeBFS(TreeNode pRoot){
        if (pRoot == null) return null;

        Queue<TreeNode> queue =  new LinkedList<TreeNode>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

        }
        return pRoot;
    }

    //DFS
    public static TreeNode MirrorTreeDFS(TreeNode pRoot){
        if (pRoot == null ) return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(pRoot);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    return pRoot;
    }
}
