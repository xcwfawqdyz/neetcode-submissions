class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int[] f =new int[n];
        Arrays.fill(f,1);
        int result=1;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(intervals[i][0]>=intervals[j][1]){
                    f[i]=Math.max(f[i],f[j]+1);
                    result=Math.max(f[i],result);
                }
            }
        }
        return n-result;
    }
}
