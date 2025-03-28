class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int gridRowL = grid.length;
        int gridColumnL = grid[0].length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int n = queries.length;
        int[] ans = new int[n];
        int[][] visited = new int[gridRowL][gridColumnL];

        int[][] indexedQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> grid[p1.a][p1.b] - grid[p2.a][p2.b]);
        queue.add(new Pair(0, 0));
        visited[0][0] = 1;
        int count = 0;

        for (int[] query : indexedQueries) {
            int queryValue = query[0];
            int queryIndex = query[1];

            while (!queue.isEmpty() && grid[queue.peek().a][queue.peek().b] < queryValue) {
                Pair p = queue.poll();
                count++;
                for (int[] dir : directions) {
                    int x = p.a + dir[0];
                    int y = p.b + dir[1];
                    if (x >= 0 && x < gridRowL && y >= 0 && y < gridColumnL && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        queue.add(new Pair(x, y));
                    }
                }
            }
            ans[queryIndex] = count;
        }

        return ans;
    }
}
