class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> dest = new HashMap<>();
        for (int[] flight : flights) {
            dest.computeIfAbsent(flight[0], i -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { src, 0, 0 });

        int[][] best = new int[n][k + 2];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int city = pos[0], cost = pos[1], stops = pos[2];

            if (city == dst) return cost;
            if (stops > k) continue;

            for (int[] neighbor : dest.getOrDefault(city, new ArrayList<>())) {
                int nextCity = neighbor[0], nextCost = cost + neighbor[1];
                if (nextCost < best[nextCity][stops + 1]) {
                    best[nextCity][stops + 1] = nextCost;
                    pq.offer(new int[] { nextCity, nextCost, stops + 1 });
                }
            }
        }

        return -1;
    }
}
