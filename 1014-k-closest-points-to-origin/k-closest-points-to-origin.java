class Pair {
    double dist;
    int[] arr;

    public Pair(double dist, int[] arr) {
        this.dist = dist;
        this.arr = arr;
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>() {

                @Override
                public int compare(Pair a, Pair b) {
                    return Double.compare(b.dist, a.dist);
                }
            }
        );
        for (int point[] : points) {
            double dist = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            pq.add(new Pair(dist, point));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int ans[][] = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll().arr;
        }
        return ans;
    }
}
