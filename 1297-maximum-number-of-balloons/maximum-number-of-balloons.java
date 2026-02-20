class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        
        charCount.put('l', charCount.getOrDefault('l', 0) / 2);
        charCount.put('o', charCount.getOrDefault('o', 0) / 2);
        
       
        int minOccurrences = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            minOccurrences = Math.min(minOccurrences, charCount.getOrDefault(c, 0));
        }
        
        return minOccurrences;
    }
}