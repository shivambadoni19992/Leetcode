class Solution {

    void permute(int []nums, Set<Integer> used, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int num : nums) {
            if(!used.contains(num)) {
                used.add(num);
                list.add(num);
                permute(nums, used, list, ans);
                used.remove(num);
                list.remove(list.size() - 1);
            }
                        
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        Set<Integer> used = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums, used, list, ans);
        return ans;
    }
}