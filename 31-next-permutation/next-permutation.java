class Solution {

    void reverse(int s, int e, int []nums) {
        while(s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int ind = -1;

        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                ind = i - 1;
                break;
            }
        }

        if(ind == -1) {
            reverse(0, n - 1, nums);
        } else {
            int eleGreaterInd = -1;
            for(int i = n - 1; i > ind; i--) {
                if(nums[i] > nums[ind]) {
                    eleGreaterInd = i;
                    break;
                }
            }
            int t = nums[ind];
            nums[ind] = nums[eleGreaterInd];
            nums[eleGreaterInd] = t;

            reverse(ind + 1, n - 1, nums);
        }
    }
}

// 1 2 4 3 -> 1 3 2 4