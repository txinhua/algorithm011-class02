class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length < 2) return profit;
        for(int i = 0;i < prices.length - 1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}