class Solution {
    public int maxProfit(int[] prices) {
        int prePrices=prices[0];
        int result=0;
        for(int i=1;i<prices.length;i++){
            result=Math.max(result,prices[i]-prePrices);
            prePrices=Math.min(prePrices,prices[i]);
        }
        return result;
    }
}
