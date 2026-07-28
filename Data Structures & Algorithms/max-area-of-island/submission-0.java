class Solution {
    private int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    res=Math.max(res,area);
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid,int i,int j){
        int m=grid.length,n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n) return 0;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        int area=1;
        for(int[] dir:dirs){
            area+=dfs(grid,i+dir[0],j+dir[1]);
        }
        return area;
    }
}
