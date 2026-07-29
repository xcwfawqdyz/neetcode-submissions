class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(String word:wordDict ){
                if(word.length()<=i && dp[i-word.length()] ){
                    String temp=s.substring(i-word.length(),i);
                    if(temp.equals(word)){
                        dp[i]=true;
                    }
                }
            }
        }
        return dp[n];

    }
}
