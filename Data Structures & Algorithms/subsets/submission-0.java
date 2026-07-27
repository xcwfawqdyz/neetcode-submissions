class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        helper(nums,0,res,tmp);
        return res;
    }
    public void helper(int[] nums,int index,List<List<Integer>> res,List<Integer> tmp){
        int n=nums.length;
        if(index>=n){
            res.add(new ArrayList<Integer>(tmp));
            return ;
        }
        helper(nums,index+1,res,tmp);
        tmp.add(nums[index]);
        helper(nums,index+1,res,tmp);
        tmp.remove(tmp.size()-1);
    }
}
