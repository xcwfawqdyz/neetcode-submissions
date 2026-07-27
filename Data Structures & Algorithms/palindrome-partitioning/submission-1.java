class Solution {
    private int[][] f;
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        int n=s.length();
        f=new int[n][n];
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
            if(isPal(s,index,i)==1){
                tmp.add(s.substring(index,i+1));
                dfs(s,i+1,tmp,res);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private int isPal(String s,int i,int j){
        if(f[i][j]!=0){
            return f[i][j];
        }
        if(i>=j){
            f[i][j]=1;
        }else if(s.charAt(i)==s.charAt(j)){
            f[i][j]=isPal(s,i+1,j-1);
        }else{
            f[i][j]=-1;
        }
        return f[i][j];
    }

    private boolean isPal2(String s,int l,int r){
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
