/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //定义前一个节点
        ListNode preNode = null;
        //定义当前节点
        ListNode currNode = head;
        //定义下一个节点
        ListNode nextNode = null;
        while(currNode!=null){
            //记录下一个要处理的节点
            nextNode = currNode.next;
            //当前节点反转，指向前一个结点
            currNode.next = preNode;
            //后移，进行下一次循环
            preNode = currNode;
            currNode = nextNode;
        }
        //返回处理后的节点
        return preNode;
    }
}