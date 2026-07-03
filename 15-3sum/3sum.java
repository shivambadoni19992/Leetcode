class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = n - 1;
            int target = -1 * nums[i];
            while(j < k) {

                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    
                } else if(k < n - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    
                } else {
                    
                    int sum = nums[j] + nums[k];

                    if(sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }

                }
            }

        }
         return res;
        
    }
}