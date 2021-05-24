package com.company.LinkedList;


//反转链表
public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public ListNode ReverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        ListNode r = null;
        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
