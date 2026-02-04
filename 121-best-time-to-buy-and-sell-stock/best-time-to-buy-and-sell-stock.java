class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max_profit = 0;
        for(int i=0;i<prices.length;i++){
            max_profit = Math.max(max_profit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max_profit;
    }
}