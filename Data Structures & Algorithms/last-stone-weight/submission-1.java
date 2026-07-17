class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que=new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            que.offer(stone);
        }
        while(que.size()>1){
            int s1=que.poll();
            int s2=que.poll();
            if(s1>s2){
                que.offer(s1-s2);
            }
        }
        return que.size()==0? 0:que.peek();
    }
}
