class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] indegree=new int[numCourses];
        for(int[] pre:prerequisites){
            indegree[pre[0]]++;
            map.computeIfAbsent(pre[1],k->new ArrayList<>()).add(pre[0]);
        }
        int finish=0;
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            finish++;
            int index=que.poll();
            List<Integer> list=map.get(index);
            if(list!=null){
                for(int item:list){
                indegree[item]--;
                if(indegree[item]==0){
                    que.offer(item);
                }
                }
            }
            
        }
        return finish==numCourses;
    }
}
