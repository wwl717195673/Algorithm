package com.company.Tree;

public class BinaryTree2LinkedList {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        TreeNode h = Convert(node1);
        int o = 0;
        while(o<6){
            o++;
            System.out.println(h.val);
            h = h.right;
        }

    }
    static TreeNode pre;
    static TreeNode head;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        recur(pRootOfTree);

        //让其首尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历是一个递增序列
    //我们只需记录上一个节点,让它与当前结点相连就行了
    public static void recur(TreeNode root){
        if(root == null) return;
        recur(root.left);
        if(pre != null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        recur(root.right);
    }
}
