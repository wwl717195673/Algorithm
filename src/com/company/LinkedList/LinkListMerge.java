package com.company.LinkedList;

import com.sun.scenario.effect.Merge;

//有序链表合并

public class LinkListMerge {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(14);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next =  null;

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(14);
        //ListNode node17 = new ListNode(15);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = null;
        //node17.next = null;

        ListNode node =Merge(node1,node11);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode p_pre = null;
        ListNode q_pre = null;
        while(p!=null && q!=null){
            while(p.val >= q.val){
                q_pre = q;
                q = q.next;
                if (q == null) break;
                if(q.val > p.val){
                    q_pre.next = p;
                    break;
                }
            }
            while(q!=null && (q.val >= p.val)){
                p_pre = p;
                p = p.next;
                if (p == null) break;
                if(p.val > q.val){
                    p_pre.next = q;
                    break;
                }
            }
        }
        if(p == null)    p_pre.next = q;
        if(q == null)    q_pre.next = p;
        if(list1.val<list2.val) return list1;
        else return list2;
    }
}
