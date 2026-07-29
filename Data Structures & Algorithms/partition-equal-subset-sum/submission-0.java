class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        sum=sum/2;
        int n=nums.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            int temp=nums[i-1];
            for(int j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(j-temp>=0){
                    dp[i][j]=dp[i][j] || dp[i-1][j-temp];
                }
            }
        }
        return dp[n][sum];
    }
}
