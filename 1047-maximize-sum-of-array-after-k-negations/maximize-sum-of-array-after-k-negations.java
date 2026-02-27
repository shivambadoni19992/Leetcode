class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int cnt = 0;
        while (cnt != k) {
            int x = pq.poll();
            pq.add(-x);
            cnt++;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}