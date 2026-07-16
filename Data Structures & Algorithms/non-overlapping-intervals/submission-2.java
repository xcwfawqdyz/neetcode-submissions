class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length,ans=1;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int[] pre=intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=pre[1]){
                ans++;
                pre=intervals[i];
            }
        }
        return n-ans;
    }
}
