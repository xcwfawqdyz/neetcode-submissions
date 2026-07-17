class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    private int quickSelect(int[] nums, int left,int right,int k){
        int pivot=nums[left];
        int l=left,r=right;
        while(left<right){
            while(left<right && nums[right]>pivot) right--;
            if(left<right) nums[left++]=nums[right];
            while(left<right && nums[left]<=pivot) left++;
            if(left<right) nums[right--]=nums[left];
        }
        nums[left]=pivot;
        if(left==k){
            return nums[left];
        }else if (left>k){
            return quickSelect(nums,l,left-1,k);
        }else return quickSelect(nums,left+1,r,k);
    }
}
