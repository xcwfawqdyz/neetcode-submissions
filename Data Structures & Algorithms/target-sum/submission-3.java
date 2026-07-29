class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=Arrays.stream(nums).sum();
        int diff=sum-target;
        if(diff<0||diff%2!=0) return 0;
        diff=diff/2;
        int m=nums.length;
        int[][] dp=new int[m][diff+1];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        if(nums[0]<=diff){
            dp[0][nums[0]]=1;
        }
        if(nums[0]==0){
            dp[0][0]=2;
        }
        
        for(int i=1;i<m;i++){
            int temp=nums[i];
            for(int j=0;j<=diff;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=temp){
                    dp[i][j]+=dp[i-1][j-temp];
                }
            }
        }
        return dp[m-1][diff];

    }
}
