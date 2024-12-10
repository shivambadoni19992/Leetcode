class Solution {

    // public int findlongest(String s1, String s2, int i, int j) {
    //     if (i == s1.length() || j == s2.length()) return 0;
    //     int res = 0;
    //     if (s1.charAt(i) == s2.charAt(j)) res = 1 + findlongest(s1, s2, i + 1, j + 1);
    //     int left = findlongest(s1, s2, i + 1, j);
    //     int right = findlongest(s1, s2, i, j + 1);
    //     return Math.max(res, Math.max(left, right));
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n + 1][n2 + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                // System.out.println(dp[i][j]);
                int left = dp[i + 1][j];
                int right = dp[i][j + 1];
                dp[i][j] = Math.max(dp[i][j], Math.max(left, right));
            }
        }
        return dp[0][0];
        // return findlongest(text1,text2,0,0);
    }
}
