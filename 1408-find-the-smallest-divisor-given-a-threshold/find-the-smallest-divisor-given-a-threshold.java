class Solution {

    public int findDivisorSum(int[] nums, int mid) {
        int sum = 0;
        for (int a : nums) {
            double num = (double) a;
            double ceil = Math.ceil((double)(num / mid));
            // System.out.println(a + " "+ceil);
            sum += ceil;
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = 1000000;
        while (start <= end) {
            int mid =  (end + start) / 2;
            int sum = findDivisorSum(nums, mid);
            // System.out.println(sum + " start " + mid + "end" + end);
            // if (sum == threshold) return mid;
            if (sum > threshold) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
