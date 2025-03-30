class Solution {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int partionEnd = lastIndex.get(s.charAt(0));
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            
            
            partionEnd = Math.max(partionEnd, lastIndex.get(s.charAt(i)));
            if (partionEnd == i) {
                int idx = (i + 1) - count;
                count += idx;
                ans.add(idx);
            }
        }
        return ans;
    }
}
