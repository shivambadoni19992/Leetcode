class Solution {

    public boolean check(int nums[], int days, int minCapacity) {
        int daysCount = 1;
        int weight = 0;
        for (int num : nums) {
            weight += num;
            if (weight > minCapacity) {
                weight = num;
                daysCount++;
                if (daysCount > days) return false;
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;
        for (int weight : weights) {
            start = Math.max(start, weight);  
            end += weight;
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(weights, days, mid)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
