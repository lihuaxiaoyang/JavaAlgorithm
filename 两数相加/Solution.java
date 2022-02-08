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
    /**
     * 计算两数之和
     * 传入链的节点，返回结果链
     * @Author: 16397
     * @Date: 2022/1/29 13:56
     * @param l1
     * @param l2
     * @Return: ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.声明返回结果的变量
        ListNode output = null;
        //2.声明中转的临时变量
        ListNode temp = null;
        //3.声明进位变量
        int carry = 0;
        //4.循环条件，传入的l1和l2节点都不能都为空
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;

            int sum = value1 + value2 + carry;

            if (output == null) {
                output = temp = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return output;
    }
}