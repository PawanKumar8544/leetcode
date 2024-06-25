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
    public TreeNode bstToGst(TreeNode root) {
         dfs(root, 0);
    return root;
}

int dfs(TreeNode node, int count){
    if(node == null) return count;
    int t = dfs(node.right, count);
    node.val += t;
    return dfs(node.left, node.val);
    }
}