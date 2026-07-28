class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            indegree[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }
        int finish=0;
        Queue<Integer> que=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            finish++;
            int node=que.poll();
            res.add(node);
            for(int neighbor:map.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    que.offer(neighbor);
                }
            }
        }
        if(numCourses!=finish) return new int[0];

        return res.stream().mapToInt(i->i).toArray();
    }
}
