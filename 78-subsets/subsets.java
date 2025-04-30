class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void find(int start, int nums[], List<Integer> list) {
        ans.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            find(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        find(0, nums, new ArrayList<>());
        return ans;
    }
}
