class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int product[] = new int[n];
        product[0] = 1;

        for(int i = 1; i < n; i++) {
            product[i] = nums[i - 1] * product[i - 1];

        }

        int multFromLast = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            product[i] *= multFromLast;
            multFromLast *= nums[i]; 
        }

        return product;


        
    }
}