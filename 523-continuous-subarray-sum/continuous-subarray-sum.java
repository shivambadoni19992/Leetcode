class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            int mod = sum % k;
            if (i != 0 && mod == 0) return true;
            if (map.get(mod) != null) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(mod, i);
        }
        return false;
    }
}
