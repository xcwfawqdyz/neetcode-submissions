class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int r,int c,int i){
        int m=board.length,n=board[0].length;
        if(r<0||r>=m || c<0||c>=n) return false;
        

        if(board[r][c]!=word.charAt(i)) return false;
        if(i==word.length()-1) return true;
        
        board[r][c]='*';
        boolean res=false;
        for(int[] dir:directions){
            int r1=r+dir[0];
            int c1=c+dir[1];
            res=res || dfs(board,word,r1,c1,i+1);
        }

        board[r][c]=word.charAt(i);
        return res;
    }
}
