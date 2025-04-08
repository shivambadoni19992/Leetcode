class Solution {
    public int getHours(int check, int []nums){
        int c = 0;
        for(int num : nums) {
            int rem = (num % check == 0) ? 0 : 1;
            c = c + (num / check) + rem;
        }
        return c;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1 , end = Integer.MAX_VALUE;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int hr = getHours(mid , piles);

            if(hr <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            

        }
        return ans;
    }
}