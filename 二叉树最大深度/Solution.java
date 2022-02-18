/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //记录左树深度
            int leftTreeDepth = maxDepth(root.left);
            //记录右树的深度
            int rightTreeDepth = maxDepth(root.right);
            return Math.max(leftTreeDepth, rightTreeDepth) + 1;
        }
    }
}