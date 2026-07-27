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
    private int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root,0);
        return result;
    }
    private int depth(TreeNode root,int deep){
        if(root==null) return 0;
        int l=depth(root.left,deep);
        int r=depth(root.right,deep);
        int val=l+r;
        result=Math.max(result,val);
        return Math.max(l,r)+1;

    }
}
