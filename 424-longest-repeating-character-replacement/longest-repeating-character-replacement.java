class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;
        int i = 0, j = 1, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        char maxChar = s.charAt(0);
        map.put(maxChar, 1);

        while(j < n) {
            char currChar = s.charAt(j);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);

            if(map.get(maxChar) <= map.get(currChar)) {
                maxChar = currChar;
            }
            while(i < n && j - i + 1 - map.get(maxChar) > k) {
                char remove = s.charAt(i);
                map.put(remove, map.get(remove) - 1);
                for(char c = 'A'; c <= 'Z'; c++) {
                    int count = map.getOrDefault(c, 0);
                    if(map.get(maxChar) < count) maxChar = c;
                }
                i++;
            }

            
            maxLength = Math.max(maxLength, j - i + 1);
            
            j++;

        }
        return maxLength;
    }
}