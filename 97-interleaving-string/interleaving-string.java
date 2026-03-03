class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, s1, s2, s3);
    }
    private boolean helper(int i, int j, String s1, String s2, String s3) {
        if (i + j == s3.length()) return true;
        if (memo[i][j] != -1) return memo[i][j] == 1;
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            ans = helper(i + 1, j, s1, s2, s3);
        }
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            ans = helper(i, j + 1, s1, s2, s3);
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}