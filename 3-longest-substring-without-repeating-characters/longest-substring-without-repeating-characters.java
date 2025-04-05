class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }
            map.put(ch, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
