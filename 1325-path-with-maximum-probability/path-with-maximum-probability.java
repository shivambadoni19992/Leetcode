class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new double[]{v, succProb[i]});
            adj.get(v).add(new double[]{u, succProb[i]});
        }

        double[] dis = new double[n];
        Arrays.fill(dis, 0.0);
        dis[start_node] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int node = (int) cur[0];
            double d = cur[1];
            if(dis[node] > d) continue;
            for (double[] nbr : adj.get(node)) {
                int next = (int) nbr[0];
                double wt = nbr[1];
                if (d * wt > dis[next]) {
                    dis[next] = d * wt;
                    pq.add(new double[]{next, dis[next]});
                }
            }
        }
        return dis[end_node] == Double.MIN_VALUE ? 0 : dis[end_node];
    }
}