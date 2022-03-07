package 链表相关;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @auther lihua
 * @create 2022-03-06 22:38
 */
public class test {

    //定义节点类
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        Deque<Node> stack = new LinkedList<>();
        Node temp = head;
        while (temp != null) {
            stack.addFirst(temp);
            temp = temp.next;
        }

        while (head != null) {
            if (head.value != stack.pollFirst().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            //记录中间位置向后一个位置开始的链表
            right = right.next;
            cur = cur.next.next;
        }

        Deque<Node> stack = new LinkedList<>();
        while (right != null) {
            stack.addFirst(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pollFirst().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(9);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(10);
        System.out.println(isPalindrome1(head));
    }
}
