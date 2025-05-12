import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Pair<Integer, Character>>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            graph[edge[0]].add(new Pair<>(edge[1], 'R'));
        }
        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new Pair<>(edge[1], 'B'));
        }

        Queue<Pair<Integer, Character>> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        queue.offer(new Pair<>(0, 'R'));
        queue.offer(new Pair<>(0, 'B'));
        visited[0][0] = true;
        visited[0][1] = true;
        ans[0] = 0;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Character> current = queue.poll();
                int node = current.getKey();
                char color = current.getValue();

                for (Pair<Integer, Character> neighbor : graph[node]) {
                    int nextNode = neighbor.getKey();
                    char edgeColor = neighbor.getValue();

                    if (edgeColor != color) {
                        int colorIdx = edgeColor == 'R' ? 0 : 1;
                        if (!visited[nextNode][colorIdx]) {
                            visited[nextNode][colorIdx] = true;
                            queue.offer(new Pair<>(nextNode, edgeColor));
                            if (ans[nextNode] == -1) {
                                ans[nextNode] = level + 1;
                            }
                        }
                    }
                }
            }
            level++;
        }

        return ans;
    }
}
