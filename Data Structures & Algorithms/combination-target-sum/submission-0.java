class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        dfs(nums,0,tmp,target,res);
        return res;
    }
    
    public void dfs(int[] nums,int index,List<Integer> tmp,int sum,List<List<Integer>> res){
        if(sum==0){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        if(sum<0 || index >=nums.length) return;

        dfs(nums,index+1,tmp,sum,res);
        
        tmp.add(nums[index]);
        dfs(nums,index,tmp,sum-nums[index],res);
        tmp.remove(tmp.size()-1);

    }
}
