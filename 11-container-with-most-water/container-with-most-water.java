class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            max = Math.max(max, Math.min(left_max, right_max) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
