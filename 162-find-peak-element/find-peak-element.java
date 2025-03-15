class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        while( left < right){
            int mid = left + (right - left)/2; //To prevent overflow for larger inputs
            if( nums[mid] > nums[mid+1]){
                right = mid;//Peak is on the left or mid
            }else{
                left = mid + 1;//Peak is on the right
            }
        }
        return left; //or right, both are the same when left == right
    }
}