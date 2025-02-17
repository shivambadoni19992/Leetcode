class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
         Set<List<Integer>> s = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                List<Integer> triplet = new ArrayList<>();
                int sum = nums[j] + nums[i] + nums[k];
                if (sum == 0) {
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    s.add(triplet);
                }
                if (sum <= 0) j++; else k--;
            }
        }
        ans = List.copyOf(s);
        return ans;
    }
}
