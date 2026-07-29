class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        String result="";
        int len=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(j-i+1>len){
                        len=j-i+1;
                        result=s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }
}
