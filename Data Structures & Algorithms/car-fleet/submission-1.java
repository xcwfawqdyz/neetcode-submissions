class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] pairs=new double[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=position[i];
            pairs[i][1]=(double)(target-position[i]) / speed[i];
        }
        Arrays.sort(pairs,(a,b)->Double.compare(b[0],a[0]));
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(!stack.isEmpty() && pairs[stack.peek()][1]>=pairs[i][1]){
                continue;
            }else{
                stack.push(i);
            }
        }
        return stack.size();
    }
}
