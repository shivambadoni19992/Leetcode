class Solution {
    int helper(int start, int end, String s, String s1, int dp[][]) {
        if(start == s.length() || end == s1.length()) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        if(s.charAt(start) == s1.charAt(end)) {
           
            return dp[start][end] = 1 + helper(start + 1, end + 1, s, s1, dp);
        } else {
            return dp[start][end] = Math.max(helper(start + 1, end, s, s1, dp), helper(start, end + 1, s, s1, dp));
        }
    }
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return helper(0, 0, s, new String(sb), dp);
        
    }
}