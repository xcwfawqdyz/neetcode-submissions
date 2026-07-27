class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        dfs(s,0,new ArrayList<>(),res);
        return res;
    }
    private void dfs(String s, int index, List<String> tmp,List<List<String>> res){
        int n=s.length();
        if(index==n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=index;i<n;i++){
            if(isPal(s,index,i)){
                tmp.add(s.substring(index,i+1));
                dfs(s,i+1,tmp,res);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    private boolean isPal(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
