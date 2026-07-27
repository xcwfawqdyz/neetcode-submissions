class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,0,res);
        return res;
    }
    private void dfs(int[] nums, int start,List<List<Integer>> res){
        int n=nums.length;
        if(start==n){
            List<Integer> tmp=new ArrayList<>();
            for(int num:nums){
                tmp.add(num);
            }
            res.add(tmp);
            return ;
        }
        for(int i=start;i<n;i++){
            swap(nums,start,i);
            dfs(nums,start+1,res);
            swap(nums,start,i);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
