package com.company.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 遍历树 递归非递归
 */
public class ReadTree {


    /**
     * 非递归的中序遍历
     */
    public static ArrayList<Integer> lnr(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            arrayList.add(root.val);
            root = root.right;
        }
        return arrayList;
    }

        /**
         * 非递归的后序遍历
         *      要点:
         *          要记录上一个访问的节点,要不然没法确认你上一次访问的是这个根结点的右节点还是左节点
         *          如果上次访问的是右节点 那么就继续向上回溯(出栈元素)
         *
         * @param root
         * @return
         */
        public static ArrayList<Integer> lrn (TreeNode root){

            TreeNode prev = null;
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (root == null) return arrayList;
            Stack<TreeNode> stack = new Stack<>();
            //stack.push(root);
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right.equals(prev)) {
                    arrayList.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    root = root.right;
                    stack.push(root);
                }
            }
            return arrayList;
        }
    }
