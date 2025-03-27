class Solution {

    public int minimumIndex(List<Integer> nums) {
        int count = 0, n = nums.size();
        int majorityElement = -1;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                majorityElement = nums.get(i);
                count = 1;
            } else if (nums.get(i) == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (majorityElement == nums.get(i)) {
                totalCount++;
            }
        }
        if (totalCount <= n / 2) return -1;
        int leftCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == majorityElement) {
                leftCount++;
                totalCount--;
            }
            if (((leftCount * 2) > (i + 1)) && (totalCount * 2) > (n - i - 1)) return i;
        }
        return -1;
    }
}
