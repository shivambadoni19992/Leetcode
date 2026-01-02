class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int[] freq = new int[256];
        for (char ch : t.toCharArray())
            freq[ch]++;

        int count = t.length();
        int start = 0, end = 0, minimumLength = Integer.MAX_VALUE, startWindow = -1;
        while (end < s.length()) {
            char currCh = s.charAt(end);
            if (freq[currCh]-- > 0)
                count--;
            while (count == 0) {
                if (end - start + 1 < minimumLength) {
                    minimumLength = end - start + 1;
                    startWindow = start;
                }
                if (freq[s.charAt(start)]++ == 0) {
                    count++; // for finding the original character from t
                }
                start++;
            }
            end++;
        }
        return startWindow == -1 ? "" : s.substring(startWindow, startWindow + minimumLength);

    }
}