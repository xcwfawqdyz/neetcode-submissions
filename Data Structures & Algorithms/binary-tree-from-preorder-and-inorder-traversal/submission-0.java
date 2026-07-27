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
    private int  index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length);
    }
    private TreeNode helper(int[] pre,int[] inorder,int inStart,int inEnd){
        if(inStart>=inEnd) return null;
        int tmpVal=pre[index];
        index++;
        TreeNode node=new TreeNode(tmpVal);
        int mid=-1;
        for(int i=inStart;i<inEnd;i++){
            if(inorder[i]==tmpVal){
                mid=i;
            }
        }
        node.left=helper(pre,inorder,inStart,mid);
        node.right=helper(pre,inorder,mid+1,inEnd);
        return node;
    }
}
