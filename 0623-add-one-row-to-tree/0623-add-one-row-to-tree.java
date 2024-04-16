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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
           TreeNode newRoot = new TreeNode(val);
           newRoot.left = root;
           return newRoot;
       }  
       return solve(root,val,depth); 
    }
    public TreeNode solve(TreeNode root,int val,int depth) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while(queue.size() > 0) {
            int count = queue.size();
            while(count-- > 0) {
                TreeNode rem = queue.poll();
                if(level == depth-1) {
                    TreeNode left = rem.left;
                    TreeNode right = rem.right;
                    rem.left = new TreeNode(val);
                    rem.right = new TreeNode(val);
                    rem.left.left = left;
                    rem.right.right = right;
                }
                else{
                    if(rem.left != null){
                        queue.add(rem.left);
                    }
                    if(rem.right != null) {
                        queue.add(rem.right);
                    }
                }
            }
            level++;
        }
        
        
        
        return root;
    }
}