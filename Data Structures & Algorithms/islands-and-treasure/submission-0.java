class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Queue<int[]> que=new LinkedList<>();
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    que.offer(new int[]{i,j});
                }
            }
        }
        while(!que.isEmpty()){
            int[] node=que.poll();
            for(int[] dir:dirs){
                int i=node[0]+dir[0];
                int j=node[1]+dir[1];
                if(i<0||j<0||i>=m||j>=n) continue;
                if(grid[i][j]!=-1 && grid[i][j]>grid[node[0]][node[1]]+1){
                    que.offer(new int[]{i,j});
                    grid[i][j]=grid[node[0]][node[1]]+1;
                }
            }
        }
    }
}
