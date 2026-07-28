class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu=new DSU(n);
        for(int[] edge:edges){
            dsu.union(edge[0],edge[1]);
        }
        return dsu.getComps();
    }
}
class DSU{
    int[] Parent,Size;
    int comps;
    public DSU(int n){
        Parent=new int[n];
        Size=new int[n];
        comps=n;
        for(int i=0;i<n;i++){
            Parent[i]=i;
            Size[i]=1;
        }
    }
    public int find(int node){
        if(Parent[node]!=node){
            Parent[node]=find(Parent[node]);
        }
        return Parent[node];
    }
    public boolean union(int u,int v ){
        int pu=find(u),pv=find(v);
        if(pu==pv) return false;
        if(Size[pu]<Size[pv]){
            int temp=pu;
            pu=pv;
            pv=temp;
        }
        Size[pu]+=Size[pv];
        Parent[pv]=pu;
        comps--;
        return true;
    }
    public int getComps(){
        return comps;
    }
}
