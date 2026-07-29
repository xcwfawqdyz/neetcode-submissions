class Solution {
    public int maxProduct(int[] nums) {
        int minNum=nums[0],maxNum=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            // minNum=minNum==0?1:minNum;
            // maxNum=maxNum==0?1:maxNum;

            int temp1=minNum*nums[i];
            int temp2=maxNum*nums[i];
            minNum=Math.min(Math.min(temp1,temp2),nums[i]);
            maxNum=Math.max(Math.max(temp1,temp2),nums[i]);
            if(maxNum>res){
                res=maxNum;
            }

        }
        return res;
    }
}
