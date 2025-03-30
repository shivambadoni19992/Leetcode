class Solution {

    public int partitionString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int subCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                subCount++;
                count.clear();
            }
            count.put(s.charAt(i), 1);
        }
        return subCount;
    }
}
