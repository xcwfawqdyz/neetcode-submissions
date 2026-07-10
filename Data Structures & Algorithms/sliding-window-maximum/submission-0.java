class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        int[] result=new int[nums.length-k+1];
        int l=0;
        for(int r=0;r<nums.length;r++){
            int ele=nums[r];
            while(!dq.isEmpty() && nums[dq.getLast()]<=ele){
                dq.removeLast();
            }
            dq.addLast(r);
            if(r>=k-1){
                while(dq.getFirst()<r-k+1){
                    dq.removeFirst();
                }
                result[l]=nums[dq.getFirst()];
                l++;
            }
        }
        return result;
    }
}
