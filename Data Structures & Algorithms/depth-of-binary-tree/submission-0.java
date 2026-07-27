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
        return depth(root,0);
    }
    private int depth(TreeNode root,int depth){
        if(root==null) return depth;
        int l=depth(root.left,depth);
        int r=depth(root.right,depth);
        return 1+Math.max(l,r);
    }
}
