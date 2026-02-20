class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;

        for(int i = n - 1; i >= 2; i--) {
            int start = 0, end = i - 1;
            int t = nums[i];
            while (start < end) {
                int curr = nums[start] + nums[end];

                if(t < curr) {
                   
                    sum += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return sum;
    }
}