package com.company.LinkedList;

//输入一个链表，输出该链表中倒数第k个结点。
//如果该链表长度小于k，请返回空。
//注意:这道题不能用反转链表,在测试样例的时候,链表的指针发生了变化,输出的结果有误

public class FindKthToTail {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(FindV1(node1,5).val);
    }

    public static ListNode FindV1(ListNode pHead,int k){
        int num = k;
        int count = 0 ;
        ListNode p = pHead;
        while(p != null){
            p=p.next;
            if (num>0) num--;
            else count++;
            //System.out.println(num+" "+count);
        }
        if(num>0){
            return null;
        }
        p = pHead;
        while ((count--) > 0){
            p = p.next;
        }
        return p;
    }
}
