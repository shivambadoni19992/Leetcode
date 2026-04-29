class Solution {
    public int lengthOfLongestSubstring(String s) {

        int end = 0;
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int prev = -1;
        while(end < len) {
            char curr = s.charAt(end);

            if(map.containsKey(curr) && map.get(curr) > prev) {
                prev = map.get(curr);
            }

            maxLength = Math.max(maxLength, end - prev);
            map.put(curr, end);
            end++;

        }

        return maxLength;
        
    }
}