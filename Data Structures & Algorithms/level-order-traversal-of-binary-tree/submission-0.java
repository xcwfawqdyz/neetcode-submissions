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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root!=null){
            que.offer(root);
        }
        while(!que.isEmpty()){
            int n=que.size();
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node=que.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
            result.add(tmp);
        }

        return result;
    }
}
