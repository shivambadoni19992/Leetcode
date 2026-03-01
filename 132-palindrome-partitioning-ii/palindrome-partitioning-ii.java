class Solution {

    boolean isPallindrome(String s, int start, int end) {

        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    int helper(int ind, String s, int []dp) {

        if(ind >= s.length()) return 0;
        if(dp[ind] != -1) return dp[ind];
        int minPart = Integer.MAX_VALUE;
        int part = Integer.MAX_VALUE;
        for(int i = ind; i < s.length(); i++) {
            if(isPallindrome(s, ind, i)) {
                part = 1 + helper(i + 1, s, dp);
            }
            minPart = Math.min(part, minPart);
        }
        
        return dp[ind] = minPart;
    }
    public int minCut(String s) {
        int n = s.length();

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, s, dp) - 1;
    }
}