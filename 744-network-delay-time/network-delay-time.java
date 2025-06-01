class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>())
                 .add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int []a,int []b) {
                return a[1] - b[1];
            }
        });
        pq.offer(new int[]{k, 0});

        Set<Integer> visited = new HashSet<>();
        int maxTime = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if (visited.contains(node)) continue;

            visited.add(node);
            maxTime = time;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor[0])) {
                    pq.offer(new int[]{neighbor[0], time + neighbor[1]});
                }
            }
        }

        return visited.size() == n ? maxTime : -1;
    }
}
