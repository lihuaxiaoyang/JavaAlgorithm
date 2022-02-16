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
            int leftTreeDeep = maxDepth(root.left);
            //记录右树深度
            int rigthTreeDeep = maxDepth(root.right);
            return Math.max(leftTreeDeep, rigthTreeDeep) + 1;
        }

    }
}