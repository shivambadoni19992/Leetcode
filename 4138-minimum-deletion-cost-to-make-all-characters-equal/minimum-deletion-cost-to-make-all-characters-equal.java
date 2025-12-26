class Solution {
    public long minCost(String s, int[] cost) {

        long []count = new long[26];
        long total = 0;
        for(int i = 0; i < cost.length; i++) {
            char c = s.charAt(i);
            count[c - 'a'] += cost[i];
            total += cost[i];
        }
        long min = Long.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            min = Math.min(min , total - count[i]);
        }
        return min;
        
    }
}