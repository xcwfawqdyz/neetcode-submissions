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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        if(root!=null){
            que.offer(root);
        }
        while(!que.isEmpty()){
            int n=que.size();
            for(int i=0;i<n;i++){
                TreeNode node=que.poll();
                if(i==n-1){
                    result.add(node.val);
                }
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
        }
        return result;
    }
}
