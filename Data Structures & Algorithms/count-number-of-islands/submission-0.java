class Solution {
    private int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int res=0;
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    isLand(grid,i,j);
                }
            }
        }
        return res;
        
    }
    private void isLand(char[][] grid,int i,int j){
        int m=grid.length,n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n) return;
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        for(int[] dir:dirs){
            int i1=i+dir[0];
            int j1=j+dir[1];
            isLand(grid,i1,j1);
        }
    }
}
