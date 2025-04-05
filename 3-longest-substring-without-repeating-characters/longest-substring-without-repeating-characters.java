class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i) {
                i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j),j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
