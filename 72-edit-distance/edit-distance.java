class Solution {

    int helper(int ind1, String word1, int ind2, String word2, int dp[][]) {
        if(ind1 == word1.length() && ind2 == word2.length()) return 0;

        if(ind1 == word1.length()) return word2.length() - ind2;
        if(ind2 == word2.length()) return word1.length() - ind1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = helper(ind1 + 1, word1, ind2 + 1, word2, dp);
        } else {
            int replace = 1 + helper(ind1 + 1, word1, ind2 + 1, word2, dp);
            int insert = 1 + helper(ind1, word1, ind2 + 1, word2, dp);
            int delete = 1 + helper(ind1 + 1, word1, ind2, word2, dp);
            return dp[ind1][ind2] = Math.min(replace, Math.min(insert, delete));
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, word1, 0, word2, dp);
    }
}