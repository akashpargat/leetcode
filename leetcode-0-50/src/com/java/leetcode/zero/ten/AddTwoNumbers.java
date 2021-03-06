package com.java.leetcode.zero.ten;

import com.java.leetcode.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers
{
    @SuppressWarnings("javadoc")
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode newNode = head;
        int num1 = 0;
        int num2 = 0;
        int carry = 0;
        while (l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val;
            if (sum < 10)
            {
                newNode.next = new ListNode(sum);
            }
            else if (sum < 10 && carry == 1)
            {
                newNode.next = new ListNode(sum + 1);
                carry = 0;
            }
            else if (sum > 10 && carry == 1)
            {
                newNode.next = new ListNode((sum % 10) + 1);
            }
            else
            {
                newNode.next = new ListNode(sum % 10);
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            newNode = newNode.next;
        }
        if (l1 != null)
        {
            while (l1.next != null)
            {
                newNode.next = new ListNode(l1.val + carry);
                l1 = l1.next;
                carry = 0;
            }
        }
        if (l2 != null)
        {
            while (l2.next != null)
            {
                newNode.next = new ListNode(l2.val + carry);
                l2 = l2.next;
                carry = 0;
            }
        }
        return helper();
    }

    private static ListNode helper()
    {
        ListNode sum = new ListNode(0);
        return sum;
    }

    @SuppressWarnings("javadoc")
    public static void main(String[] args)
    {
        ListNode firstNode = new ListNode(9);
        firstNode.next = new ListNode(9);
        firstNode.next.next = new ListNode(9);
        firstNode.next.next.next = new ListNode(9);
        ListNode secondNode = new ListNode(9);
        secondNode.next = new ListNode(9);
        secondNode.next.next = new ListNode(9);
        secondNode.next.next.next = new ListNode(9);
        addTwoNumbers(firstNode, secondNode);
    }
}
