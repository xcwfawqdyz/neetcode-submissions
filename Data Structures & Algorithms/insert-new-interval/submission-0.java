class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList=new ArrayList<>();
        List<int[]> result=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            intervalList.add(intervals[i]);
        }
        intervalList.add(newInterval);
        intervalList.sort((a,b)->a[0]-b[0]);
        int[] pre=intervalList.get(0);
        for(int i=1;i<intervalList.size();i++){
            int[] cur=intervalList.get(i);
            if(cur[0]<=pre[1]){
                pre[1]=Math.max(cur[1],pre[1]);
            }else{
                result.add(pre);
                pre=cur;
            }
        }
        result.add(pre);
        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            res[i][0]=result.get(i)[0];
            res[i][1]=result.get(i)[1];
        }
        return res;
    }
}
