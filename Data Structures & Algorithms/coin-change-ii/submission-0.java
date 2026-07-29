class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length;
        int[][] dp=new int[m][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            int coin=coins[i];
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=coin && dp[i][j-coin]!=0){
                    dp[i][j]+=dp[i][j-coin];
                }
            }
        }
        return dp[m-1][amount];
    }
}
