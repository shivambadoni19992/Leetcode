class Solution {
    public int numSquares(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            int sq = i * i;

            for(int j = sq; j <= n; j++) {
                if(dp[j - sq] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - sq] + 1);
            }
        }
        return dp[n];
        
    }
}