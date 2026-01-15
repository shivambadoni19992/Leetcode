class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(ch, j);
            j++;
        } 
        return maxLength;
    }
}