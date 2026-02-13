class Solution {
    void helper(int []nums, int start, List<Integer> list, List<List<Integer>> ans) {
        if(start == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        helper(nums, start + 1, list, ans);
        list.add(nums[start]);
        helper(nums, start + 1, list, ans);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}