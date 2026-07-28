class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        Queue<int[]> pacQue=new LinkedList<>();
        Queue<int[]> atlanticQue=new LinkedList<>();
        for(int i=0;i<m;i++){
            pacQue.add(new int[]{i,0});
            atlanticQue.add(new int[]{i,n-1});
        }
        for(int j=0;j<n;j++){
            pacQue.add(new int[]{0,j});
            atlanticQue.add(new int[]{m-1,j});
        }
        bfs(heights,pacific,pacQue);
        bfs(heights,atlantic,atlanticQue);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;

    }
    private void bfs(int[][] heights,boolean[][] matrix,Queue<int[]> que){
        int m=heights.length,n=heights[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            int[] node=que.poll();
            matrix[node[0]][node[1]]=true;
            for(int[] dir:dirs){
                int i=node[0]+dir[0];
                int j=node[1]+dir[1];
                if(i<0||j<0||i>=m||j>=n) continue;
                if(heights[i][j]>=heights[node[0]][node[1]]&& matrix[i][j]==false){
                    que.offer(new int[]{i,j});
                    matrix[i][j]=true;
                }
            }
        }

    }
}
