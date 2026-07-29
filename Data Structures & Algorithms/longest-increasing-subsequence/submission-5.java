class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp=new ArrayList<>();
        int n=nums.length;
        dp.add(nums[0]);
        for(int num:nums){
            if(num>dp.get(dp.size()-1)){
                dp.add(num);
            }else{
                // int i=0;
                // while(i<dp.size() && num>dp.get(i)){
                //     i++;
                // }
                int i=find(dp,num);
                dp.set(i,num);
            }
        }
        return dp.size();
    }
    private int find(List<Integer> nums,int k ){
        int n=nums.size();
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums.get(mid)<k){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}
