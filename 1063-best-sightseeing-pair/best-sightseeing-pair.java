class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int max_till_now = values[0];
        for(int i=1;i<values.length;i++){
            max = Math.max(max,max_till_now +values[i]-i);
            max_till_now = Math.max(max_till_now,values[i]+i);
        }
        return max;
    }
}