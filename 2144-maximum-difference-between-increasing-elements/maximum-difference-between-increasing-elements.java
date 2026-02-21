class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num < min) {
                min = num;
            } else {
                ans = Math.max(num - min, ans);
            }
        }
        return ans == 0 ? -1 : ans;
        
    }
}