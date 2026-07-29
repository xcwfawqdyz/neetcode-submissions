class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        sum=sum/2;
        int n=nums.length;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            int temp=nums[i-1];
            for(int j=sum;j>=1;j--){
                if(j-temp>=0){
                    dp[j]=dp[j] || dp[j-temp];
                }
            }
        }
        return dp[sum];
    }
}
