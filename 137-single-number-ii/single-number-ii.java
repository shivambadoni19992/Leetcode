class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i = 0; i <= 31; i++) {
            int bit = 1 << i;
            int count = 0;
            for(int num : nums) {
                if((num & bit)== bit) count++;
            }

            if(count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}