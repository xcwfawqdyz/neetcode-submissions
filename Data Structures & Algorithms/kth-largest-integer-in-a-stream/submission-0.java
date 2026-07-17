class KthLargest {
    PriorityQueue<Integer> que;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        que=new PriorityQueue<>();
        for(int num:nums){
            que.offer(num);
            if(que.size()>k){
                que.poll();
            }
        }
    }
    
    public int add(int val) {
        que.offer(val);
        if(que.size()>k){
            que.poll();
        }
        return que.peek();
    }
}
