import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //HashSet集合
    public boolean hasCycle(ListNode head) {
        //创建HashSet集合用于保存节点
        Set<ListNode> mySet = new HashSet<ListNode>();

        //循环条件，节点一直不为空
        while (head != null) {
            //向HashSet中追加数据，如果返回false，说明有重复值，即存在环结构
            if (!mySet.add(head)) {
                return true;
            }
            //节点后移
            head = head.next;
        }
        //循环条件结束，证明节点为空=>不存在环形结构
        return false;
    }

    //快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}