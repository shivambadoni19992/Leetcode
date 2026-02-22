class Solution {

    boolean helper(int start ,int end, String s, int exchanges) {
        if(exchanges > 1) return false;
        if(start >= end) return true;
        if(s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
            return helper(start, end, s, exchanges);
        } else {
            return helper(start + 1, end, s, exchanges + 1) || helper(start, end - 1, s,  exchanges + 1);
        }
    }
    public boolean validPalindrome(String s) {
        return helper(0, s.length() - 1, s, 0);
    }
}