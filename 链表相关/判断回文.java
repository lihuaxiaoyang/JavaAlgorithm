package 链表相关;

import jdk.nashorn.internal.objects.NativeNumber;
import org.junit.Test;

import java.util.*;

/**
 * @auther lihua
 * @create 2022-03-06 20:21
 */
public class 判断回文 {
    @Test
    public void test1() {
//        Stack<Integer> integers = new Stack<>();
//        integers.push(10);
//        integers.push(9);
//        integers.push(8);
//        System.out.println(integers.pop());
//        System.out.println(integers.pop());
//        System.out.println(integers.pop());
        Deque<Integer> deque = new LinkedList<>();
//        deque.push(10);
//        deque.push(9);
//        deque.push(8);
//        System.out.println(deque.pop());
//        System.out.println(deque.pop());
//        System.out.println(deque.pop());
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(10);
//        queue.add(9);
//        queue.add(8);
//        System.out.println(queue);

        deque.addFirst(10);
        deque.addFirst(9);
        deque.addFirst(8);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }

    @Test
    public void test2() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//小顶优先队列
        priorityQueue.add(6);
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());
    }

    @Test
    public void test3() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.add(6);
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static boolean isPalindrome1(Node head) {
        Deque<Node> stack = new LinkedList<Node>();
        Node cur = head;
        while (cur != null) {
            stack.addFirst(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pollFirst().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head) {
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

        Deque<Node> stack = new LinkedList<Node>();
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

    public static boolean isPalindrom3(Node head) {
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
//        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
    }
}
