class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(java.util.Collections.reverseOrder());
        for (int n : amount) {
            pq.offer(n);
        }
        
        int res = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (!pq.isEmpty() && pq.peek() != 0) {
                int b = pq.poll();
                if (a - 1 > 0) pq.offer(a - 1);
                if (b - 1 > 0) pq.offer(b - 1);
                res++;
            } else {
                res += a;
            }
        }
        return res;
    }
}