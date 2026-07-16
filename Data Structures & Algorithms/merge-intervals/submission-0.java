class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] pre = intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=pre[1]){
                pre[1]=Math.max(intervals[i][1],pre[1]);
            }else{
                result.add(pre);
                pre=intervals[i];
            }
        }
        result.add(pre);
        return result.toArray(new int[result.size()][]);
    }
}
