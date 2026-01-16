class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while(left < right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}