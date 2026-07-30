class Solution {
    private int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] mem=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=0;
                if(mem[i][j]==0){
                     temp=dfs(matrix,mem,i,j);
                    
                }else{
                    temp=mem[i][j];
                }
                res=Math.max(temp,res);
            }
        }
        return res;
    }
    private int dfs(int[][] matrix,int[][] mem,int i,int j){
        if(mem[i][j]!=0){
            return mem[i][j];
        }
        int m=matrix.length,n=matrix[0].length;
        mem[i][j]=1;
        int temp=0;
        for(int[] dir:dirs){
            int i1=i+dir[0];
            int j1=j+dir[1];
            if(i1>=0 && j1>=0 && i1<m && j1<n && matrix[i][j]>matrix[i1][j1]){
                temp=Math.max(temp,dfs(matrix,mem,i1,j1));
            }
        }
        mem[i][j]+=temp;
        return mem[i][j];
    }
}
