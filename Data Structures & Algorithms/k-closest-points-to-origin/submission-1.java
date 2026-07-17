class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> que=new PriorityQueue<>((a,b)->
            b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        for(int[] point:points){
            que.offer(point);
            if(que.size()>k){
                que.poll();
            }
        }
        int[][] res=new int[k][2];
        int start=k-1;
        while(!que.isEmpty()){
            res[start]=que.poll();
            start--;
        }
        
        return res;

    }
}
