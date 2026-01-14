class Solution {
    public int maxTurbulenceSize(int[] nums) {
        if(nums.length == 1) return nums.length;
        if(nums.length == 2) return nums[0] == nums[1] ? 1 : 2;
        int ans = 0;
        int start = 0;
        boolean greater = nums[0] > nums[1];

        for(int i = 2; i < nums.length; i++) {
         boolean curr = nums[i - 1] > nums[i];
         if(nums[i] == nums[i - 1]) {
            start = i;
         } else if (curr == greater) {
            start = i -1;
         } else {
            
            greater = curr;
         }
         ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}