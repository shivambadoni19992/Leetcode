class Solution {

    int helper(int ind1, String text1, int ind2, String text2, int dp[][]) {
        if(ind1 == text1.length() || ind2 == text2.length()) {
            return 0;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + helper(ind1 + 1, text1, ind2 + 1, text2, dp);
        } else {
            return dp[ind1][ind2] = Math.max(helper(ind1 + 1, text1, ind2, text2, dp), helper(ind1, text1, ind2 + 1, text2, dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, text1, 0, text2, dp);
    }
}