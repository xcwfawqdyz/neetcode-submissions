class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(n,n,"",res);
        return res;
    }
    private void dfs(int left,int right,String s,List<String> res){
        if(right==0){
            res.add(s);
            return ;
        }
        if(left>0){
            dfs(left-1,right,s+'(',res);
        }

        if(right>left){
            dfs(left,right-1,s+')',res);
        }
    }
}
