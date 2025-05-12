class Solution {

    public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int n = graph.length;
        int target = (1 << n) - 1;
        int visited[][] = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            int current = (1 << i);
            queue.add(new int[] { i, current });
            visited[i][current] = 1;
        }

        int totalEdge = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currNode = queue.poll();
                int bit = currNode[1];
                int node = currNode[0];
                if (bit == target) {
                    return totalEdge;
                }
                for (int j = 0; j < graph[node].length; j++) {
                    int destNode = graph[node][j];
                    int destBit = (1 << destNode);
                    int targetReach = bit | destBit;
                    if (visited[destNode][targetReach] == 1) {
                        continue;
                    }
                    visited[destNode][targetReach] = 1;

                    queue.add(new int[] { destNode, targetReach });
                }
            }
            totalEdge++;
        }
        return -1;
    }
}
