class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]< nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        int pivot=l;
        int result=binarySearch(nums,target,0,l-1);
        if(result!=-1){
            return result;
        }
        return binarySearch(nums,target,l,nums.length-1);
    }
    public int binarySearch(int[] nums, int target,int l,int r){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
