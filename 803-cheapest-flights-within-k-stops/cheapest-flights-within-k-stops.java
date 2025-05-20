class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], a -> new ArrayList<>())
                 .add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { src, 0, 0 });

        int[] minCostAtNode = new int[n];
        Arrays.fill(minCostAtNode, Integer.MAX_VALUE);
        minCostAtNode[src] = 0;

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0], cost = cur[1], stops = cur[2];

            if (city == dst) {
                minCost = Math.min(minCost, cost);
                continue;
            }

            if (stops > k) continue;

            for (int[] neighbor : graph.getOrDefault(city, new ArrayList<>())) {
                int nextCity = neighbor[0], price = neighbor[1];
                int newCost = cost + price;

                if (newCost < minCostAtNode[nextCity]) {
                    minCostAtNode[nextCity] = newCost;
                    queue.offer(new int[] { nextCity, newCost, stops + 1 });
                }
            }
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
