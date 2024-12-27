class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = nums[0];

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n < 2) {
            ans.add(candidate1);
            return ans;
        }
        int candidate2 = nums[1];
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != candidate2) {
                count1++;
                candidate1 = nums[i];
            } else if (count2 == 0 && nums[i] != candidate1) {
                count2++;
                candidate2 = nums[i];
            } else if (nums[i] == candidate1) count1++; else if (nums[i] == candidate2) count2++; else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) count1++; else if (nums[i] == candidate2) count2++;
        }
        if (count1 > (n / 3)) ans.add(candidate1);
        if (count2 > (n / 3)) ans.add(candidate2);
        return ans;
    }
}
