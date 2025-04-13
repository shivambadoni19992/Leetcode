class Solution {

    public String smallestPalindrome(String s) {
        int[] charCount = new int[26];
        boolean isEven = (s.length() % 2 == 0) ? true : false;
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int chPos = -1;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 != 0) {
                chPos = i;
                charCount[i]--;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int count1 = charCount[i] / 2;
            while (count1 > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                count1--;
            }
            int count2 = charCount[25 - i] / 2;
            while (count2 > 0) {
                char ch = (char) ('a' + 25 - i);
                sb1.append(ch);
                count2--;
            }
        }

        if (chPos != -1) {
            char ch = (char) ('a' + chPos);
            sb.append(ch);
        }

        return sb.toString() + sb1.toString();
    }
}
