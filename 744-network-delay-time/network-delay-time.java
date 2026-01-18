class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[]time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.computeIfAbsent(u, m -> new ArrayList<>()).add(new int[] {v, t});
        }

        Set<Integer> vis = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int []curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            vis.add(node);
            if(vis.size() == n) return time;
            if(adj.containsKey(node)) {
                for(int []edge : adj.get(node)) {
                    if(!vis.contains(edge[0])) {
                        pq.add(new int[] {edge[0], edge[1] + time});
                    }
                }
            }
            
        }
        return -1;
        
    }
}