class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || heights[stack.peek()]>heights[i] ) ){
                int index=stack.pop();
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                int area=heights[index]*w;
                result=Math.max(area,result);
            }
            stack.push(i);
        }
        return result;
    }
}
