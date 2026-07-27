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
    private int res=0;
    public int goodNodes(TreeNode root) {
        res=1;
        if(root==null) return res;

        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return res;
    }
    private void dfs(TreeNode root,int temp){
        if(root==null) return ;
        if(root.val>=temp) res++;
        temp=Math.max(temp,root.val);
        dfs(root.left,temp);
        dfs(root.right,temp);
    } 
}
