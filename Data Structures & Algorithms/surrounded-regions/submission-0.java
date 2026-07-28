class Solution {
    private int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j);
            }
            if(board[m-1][j]=='O'){
                dfs(board,m-1,j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j){
        int m=board.length,n=board[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        if(board[i][j]!='O') return ;

        board[i][j]='#';
        for(int[] dir:dirs){
            dfs(board,i+dir[0],j+dir[1]);
        }

    }
}
