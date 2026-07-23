class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=n,bottom=m,up=0;
        List<Integer> result=new ArrayList<>();
        while(left<right && bottom>up){
            for(int col=left;col<right;col++){
                result.add(matrix[up][col]);
            }
            up++;
            for(int row=up;row<bottom;row++){
                result.add(matrix[row][right-1]);
            }
            right--;

            if(bottom>up){
                
                for(int col=right-1;col>=left;col--){
                result.add(matrix[bottom-1][col]);
                }
                bottom--;

            }
            
            if(left<right){
                for(int row=bottom-1;row>=up;row--){
                result.add(matrix[row][left]);
            }
            left++;
            }
            
        }
        return result;
    }
}
