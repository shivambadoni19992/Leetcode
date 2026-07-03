class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;
        while(left < right) {

            int currBar = -1;

            if(height[left] < height[right]) {
                currBar = height[left];
                left++;
            } else {
                currBar = height[right];
                right--;
            }

            maxWater = Math.max(maxWater, currBar * (right - left + 1));
        }
        return maxWater;
        
    }
}