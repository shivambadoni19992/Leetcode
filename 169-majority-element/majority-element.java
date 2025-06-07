class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int ele = nums[0];
        for(int i = 1;i < nums.length; i++){
            if(nums[i] != ele) {
                count--;
                if(count == 0) {
                    ele = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return ele;
    }
}

// 3 2 3

// c= 1
// num = 3