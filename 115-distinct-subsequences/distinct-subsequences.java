class Solution {

    int helper(int ind1, String s, int ind2, String t, int dp[][]) {
        if(ind2 == t.length()) {
            return 1;
        }

        if(ind1 == s.length()) {
            return 0;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        int take = 0;
        if(s.charAt(ind1) == t.charAt(ind2)) {
            take = helper(ind1 + 1, s, ind2 + 1, t, dp);
        }
        int notTake = helper(ind1 + 1, s, ind2, t, dp);
        return dp[ind1][ind2] = take + notTake;
    }
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, s, 0, t, dp);
        
    }
}