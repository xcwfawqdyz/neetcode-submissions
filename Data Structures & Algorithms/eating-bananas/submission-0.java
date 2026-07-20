class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles=Arrays.stream(piles).max().getAsInt();
        int res=maxPiles;
        int l=1,r=maxPiles;
        while(l<=r){
            int mid=l+(r-l)/2;
            int totalTime=0;
            for(int pile:piles){
                totalTime+= Math.ceil((double)pile/mid);
            }
            if(totalTime<=h){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}
