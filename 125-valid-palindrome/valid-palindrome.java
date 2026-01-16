class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        String sLower = s.toLowerCase();

        while(i < j) {
            char start = sLower.charAt(i);
            char end = sLower.charAt(j);
            if(!(start >= 'a' && start <= 'z') && !(start >= '0' && start <= '9')) i++;
            else if(!(end >= 'a' && end <= 'z') && !(end >= '0' && end <= '9')) j--;
            else {
                if(end != start) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}