class Solution {
    int helper(String word1, String word2, int idx1, int idx2, int [][]memo) {
        if(idx1 == word1.length() && idx2 == word2.length()) return 0;

        if(idx1 == word1.length()) return word2.length() - idx2 ;
        if(idx2 == word2.length()) return word1.length()- idx1;

        if(memo[idx1][idx2] != -1) return memo[idx1][idx2];
        int insert = Integer.MAX_VALUE;
        int replace = Integer.MAX_VALUE;
        int delete = Integer.MAX_VALUE;
        if(word1.charAt(idx1) == word2.charAt(idx2)) {
            return memo[idx1][idx2] = helper(word1, word2, idx1 + 1 , idx2 + 1, memo);
        } else {
            insert = 1 + helper(word1, word2, idx1, idx2 + 1, memo);
            delete = 1 + helper(word1, word2, idx1 + 1, idx2, memo);
            replace = 1 + helper(word1, word2, idx1 + 1, idx2 + 1, memo);
            return memo[idx1][idx2] = Math.min(insert, Math.min(delete, replace));

        }
    }
    public int minDistance(String word1, String word2) {

        int memo[][] = new int[word1.length()][word2.length()];

        for(int i = 0; i< word1.length();i++) {
            Arrays.fill(memo[i], -1);
        }

        return helper(word1, word2, 0, 0, memo);
        
    }
}