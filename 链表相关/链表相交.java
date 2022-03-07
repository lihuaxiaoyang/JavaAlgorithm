package 链表相关;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther lihua
 * @create 2022-03-07 10:58
 */
public class 链表相交 {


    //创建链表
    static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //判断是否有环，有则返回入环节点，无则返回null
    public static boolean judgeFun1(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        //定义额外结构的方法
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }


    //快慢指针的方法
    public static Node judgeFun2(Node head) {
        Node slow = head;
        Node quick = head.next;
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = null;
        while (quick != null) {
            if (slow == quick) {
                temp = slow;
                //错开位置
                slow = slow.next;
                break;
            } else {
                slow = slow.next;
                quick = quick.next.next;
            }
        }
        Node tempNode = head;
        if (temp != null) {
            while (tempNode != slow) {
                tempNode = tempNode.next;
                slow = slow.next;
            }
            return tempNode;
        }
        return null;
    }

    //找到链表第一个入环节点，如果无环，返回null
    public static Node judgeFun3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;// n1 -> slow
        Node n2 = head.next.next;// n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    //两个链表相交
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        //记录链表长度差值（即为链表1长度的值减去链表2长度的值）
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;//谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(9);
        head.next.next = new Node(8);
        head.next.next.next = new Node(7);
        head.next.next.next.next = head.next;
//        head.next.next.next.next = new Node(666);

        Node node = judgeFun3(head);

        int a = 10;
//        System.out.println(judgeFun1(head));
    }
}
