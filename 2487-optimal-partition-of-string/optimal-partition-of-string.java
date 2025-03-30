class Solution {

    public int partitionString(String s) {
        Set<Character> count = new HashSet<>();
        int subCount = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count.contains(ch)) {
                subCount++;
                count.clear();
            }
            count.add(ch);
        }
        return subCount;
    }
}
