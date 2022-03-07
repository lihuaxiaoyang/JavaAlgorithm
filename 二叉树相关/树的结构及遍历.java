package 二叉树相关;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther lihua
 * @create 2022-03-07 14:16
 */
public class 树的结构及遍历 {

    //定义树结构
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //递归序、先序、中序、后序

    public static void f(Node head) {
        //1
        if (head == null) {
            return;
        }
        //1
        f(head.left);
        //2
        //2
        f(head.right);
        //3
        //3
    }

    //先序遍历
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序遍历
    public static void midOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        midOrderRecur(head.left);
        System.out.print(head.value + " ");
        midOrderRecur(head.right);
    }

    //后序遍历
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }


    //非递归行为现序遍历
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order：");
        if (head != null) {
            Deque<Node> stack = new LinkedList<>();
            stack.addFirst(head);
            while (!stack.isEmpty()) {
                head = stack.pollFirst();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.addFirst(head.right);
                }
                if (head.left != null) {
                    stack.addFirst(head.left);
                }
            }
        }
        System.out.println();
    }


    //二叉树层序遍历
    public static void w(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(head);
        while (!queue.isEmpty()) {
            //先进先出，尾插法
            Node cur = queue.pollFirst();
            System.out.println(cur.value);

            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        //recursive
        System.out.println("=============recursive===============");
        System.out.print("pre-order：");
        preOrderRecur(head);
        System.out.println();
        System.out.print("mid-order：");
        midOrderRecur(head);
        System.out.println();
        System.out.print("pos-order：");
        posOrderRecur(head);


        System.out.println("=====================================");
        preOrderUnRecur(head);
    }
}
