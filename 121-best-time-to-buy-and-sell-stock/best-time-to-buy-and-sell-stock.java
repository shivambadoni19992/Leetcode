class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int buy = prices[0];
        for(int i=1; i<prices.length; i++){
            int current_profit = prices[i] - buy;
            max_profit = Math.max(max_profit,current_profit);
            buy = Math.min(buy,prices[i]);
        }
        return max_profit;
    }
}