class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set=new HashSet<>();
        int res=0;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                dfs(i,adj,set);
                res++;
            }
        }
        return res;
        
    }
    private void dfs(int node,List<List<Integer>> adj, Set<Integer> set){
        if(set.contains(node)){
            return;
        }
        set.add(node);
        for(int nei:adj.get(node)){
            if(nei==node) continue;
            dfs(nei,adj,set);
        }
    }
}
