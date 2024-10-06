class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans_product[] = new int[nums.length];
        int prod = 1;
        for (int i=0;i<nums.length;i++) {
            prod = prod * nums[i];
            ans_product[i] = prod;
        }
        prod=1;
        for(int i=nums.length-1;i>0;i--){
            ans_product[i] = prod * ans_product[i-1];
            prod = prod * nums[i];
        }
        ans_product[0]=prod;
        return ans_product;
    }
}