class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        dfs(candidates,target,new ArrayList<Integer>(),0,res);
        return res;
    }
    public void dfs(int[] candidates,int target,List<Integer> tmp,int index,List<List<Integer>> res){
        int n=candidates.length;
        
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(index>=n || target<0) return;
        

        tmp.add(candidates[index]);
        dfs(candidates,target-candidates[index],tmp,index+1,res);
        tmp.remove(tmp.size()-1);

        while(index+1<n && candidates[index]==candidates[index+1]){
            index++;
        }

        dfs(candidates,target,tmp,index+1,res);
        

    }
}
