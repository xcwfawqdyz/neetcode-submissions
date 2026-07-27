class Solution {
    public boolean canJump(int[] nums) {
        int left=nums[0];
        for(int i=1;i<nums.length;i++){
            if(left>=i){
                left=Math.max(i+nums[i],left);
            }else{
                break;
            } 
        }
        return left>=nums.length-1;
    }
}
