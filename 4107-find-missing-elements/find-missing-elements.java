class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);
        int start  = nums[0];
        int end = nums[nums.length - 1];
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            if(i == nums[j]) {
                j++;
            } else {
                ans.add(i);
            }
        }

        return ans;
        
    }
}