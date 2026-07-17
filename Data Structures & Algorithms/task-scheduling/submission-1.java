class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> que=new LinkedList<>();
        int time=0;
        Map<Character, Integer> map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        for(char task:map.keySet()){
            maxHeap.offer(map.get(task));
        }
        while(!que.isEmpty() || !maxHeap.isEmpty() ){
            time++;
            if(!maxHeap.isEmpty()){
                int temp=maxHeap.poll();
                if(temp>1) que.offer(new int[]{temp-1,time+n});
            }else{
                time=que.peek()[1];
            }
            
            if(!que.isEmpty() && que.peek()[1]==time){
                maxHeap.add(que.poll()[0]);
            }
        }
        return time;
    }
}
