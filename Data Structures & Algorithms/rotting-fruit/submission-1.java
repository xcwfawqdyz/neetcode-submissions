class Solution {
    public int orangesRotting(int[][] grid) {
        int res=0;
        Queue<int[]> que=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        int refresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    que.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    refresh++;
                }

            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(refresh>0&&!que.isEmpty()){
            res++;
            int N=que.size();
            for(int k=0;k<N;k++){
                int[] node=que.poll();
                for(int[] dir:dirs){
                    int i=node[0]+dir[0];
                    int j=node[1]+dir[1];
                    if(i<0||j<0||i>=m||j>=n) continue;
                    if(grid[i][j]==1){
                        refresh--;
                        que.offer(new int[]{i,j});
                        grid[i][j]=2;
                    }
                }
            }
        }
        return refresh==0?res:-1;
    }
}
