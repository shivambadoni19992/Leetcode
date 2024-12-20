class Solution {

    // public int LIS(int[] nums, int ind, int ele) {
    //     if (ind == 0) return (ele > nums[ind]) ? 1 : 0;
    //     int res = -1;
    //     int notTake = 0;
    //     int take = 0;
    //     if (nums[ind] >= ele) {
    //         notTake = LIS(nums, ind - 1, ele);
    //     } else {
    //         take = 1 + LIS(nums, ind - 1, nums[ind]);
    //         notTake = LIS(nums, ind - 1, ele);
            
    //     }
    //     res = Math.max(take, notTake);
    //     return res;
    // }

    public int lengthOfLIS(int[] nums) {
         int n=nums.length;
        
        int [] dp=new int[n];
        
        int lengthOfLIS=0;
        
        for(int current:nums){
            
            int i=0,j=lengthOfLIS;
            
            while(i!=j){
                int mid=(i+j)/2;
                
                if(dp[mid]<current) i=mid+1;
                
                else j=mid;
            }
            
            dp[i]=current;
            
            if(i==lengthOfLIS) lengthOfLIS++;
        }
        return lengthOfLIS;
    }
}
