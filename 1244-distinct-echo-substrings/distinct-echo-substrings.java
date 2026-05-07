class Solution {
    public int distinctEchoSubstrings(String text) {
       Set<String> set = new HashSet<>();
        for (int len = 1; len <= text.length() / 2; len++) {
            for (int l = 0, r = len, count = 0; l < text.length() - len; l++, r++) {
                if (text.charAt(l) == text.charAt(r)) count++;
                else count = 0;

                if (count == len) {
                    set.add(text.substring(l - len + 1, l + 1));
                    count--;
                }
            }
        }

        return set.size();
    }

}