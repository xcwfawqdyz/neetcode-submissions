class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp=new ArrayList<>();
        int n=nums.length;
        dp.add(nums[0]);
        for(int num:nums){
            if(num>dp.get(dp.size()-1)){
                dp.add(num);
            }else{
                int i=0;
                while(i<dp.size() && num>dp.get(i)){
                    i++;
                }
                dp.set(i,num);
            }
        }
        return dp.size();
    }
}
