class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DSU dsu=new DSU(n);
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] pointx=points[i];
            for(int j=i+1;j<n;j++){
                int[] pointy=points[j];
                int dist=Math.abs(pointx[0]-pointy[0])+Math.abs(pointx[1]-pointy[1]);
                edges.add(new int[]{dist,i,j});
            }
        }
        edges.sort((a,b)->a[0]-b[0]);
        int res=0;
        for(int[] edge:edges){
            if(dsu.union(edge[1],edge[2])){
                res+=edge[0];
            }
        }
        return res;
    }
}
class DSU{
    int[] Parent,Size;
    int compos;
    public DSU(int n){
        Parent=new int[n];
        Size=new int[n];
        compos=n;
        for(int i=0;i<n;i++){
            Parent[i]=i;
            Size[i]=1;
        }
    }
    public int find(int node ){
        if(Parent[node]!=node){
            Parent[node]=find(Parent[node]);
        }
        return Parent[node];
    }
    public boolean union(int u,int v){
        int pu=find(u),pv=find(v);
        if(pu==pv) return false;
        if(Size[pu]<Size[pv]){
            int temp=pu;
            pu=pv;
            pv=temp;
        }
        Size[pu]+=Size[pv];
        Parent[pv]=pu;
        compos--;
        return true;
    }
}
