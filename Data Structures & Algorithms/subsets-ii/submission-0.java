class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void dfs(int[] nums,int index,List<Integer> tmp,List<List<Integer>> res){
        int n=nums.length;
        if(index==n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(index>n){
            return ;
        }
        tmp.add(nums[index]);
        dfs(nums,index+1,tmp,res);
        tmp.remove(tmp.size()-1);

        while(index+1<n && nums[index]==nums[index+1]){
            index++;
        }
        dfs(nums,index+1,tmp,res);
    }
}
