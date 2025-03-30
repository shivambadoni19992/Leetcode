class Solution {

    public int partitionString(String s) {
        Set<Character> count = new HashSet<>();
        int subCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (count.contains(s.charAt(i))) {
                subCount++;
                count.clear();
            }
            count.add(s.charAt(i));
        }
        return subCount;
    }
}
