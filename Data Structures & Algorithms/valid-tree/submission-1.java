class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1) return false;
        List<List<Integer>> adj=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{0,-1});
        while(!que.isEmpty()){
            int[] item=que.poll();
            set.add(item[0]);
            for(int nei:adj.get(item[0])){
                if(nei==item[1]) continue;
                if(set.contains(nei)) return false;
                que.add(new int[]{nei,item[0]});
            }

        }
        return set.size()==n;
    }
}
