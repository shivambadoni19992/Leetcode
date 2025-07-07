class Solution {

     public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minDist(0, 0, word1, word2, memo);
    }

    private int minDist(int i, int j, String word1, String word2, int[][] memo) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = minDist(i + 1, j + 1, word1, word2, memo);
        } else {
            int del = 1 + minDist(i + 1, j, word1, word2, memo);
            int ins = 1 + minDist(i, j + 1, word1, word2, memo);
            int rep = 1 + minDist(i + 1, j + 1, word1, word2, memo);
            memo[i][j] = Math.min(del, Math.min(ins, rep));
        }

        return memo[i][j];
    }
}