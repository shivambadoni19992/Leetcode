class Solution {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();
        int n1 = t.length();

        while (j < n1 && i < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
