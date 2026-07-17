class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> que=new PriorityQueue<>((a,b)->
            b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        List<int[]> res=new ArrayList<>();
        for(int[] point:points){
            que.offer(point);
            if(que.size()>k){
                que.poll();
            }
        }
        while(!que.isEmpty()){
            res.add(que.poll());
        }
        Collections.reverse(res);
        return res.toArray(new int[k][]);


    }
}
