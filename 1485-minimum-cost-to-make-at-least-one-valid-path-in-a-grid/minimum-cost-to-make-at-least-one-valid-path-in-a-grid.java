class Solution {

    public int getDirection(int a) {
        return a % 2 == 0 ? -1 : 1;
    }

    public boolean isValid(int row, int column, int n, int m) {
        return row >= 0 && row < n && column >= 0 && column < m;
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        Arrays.stream(vis).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<>() {

                @Override
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            }
        );
        pq.offer(new int[] { 0, 0, 0 });
        vis[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currX = curr[0], currY = curr[1], currC = curr[2];
            if (currX == n - 1 && currY == m - 1) {
                return currC;
            }
            int currVal = grid[currX][currY];
            int currDir = getDirection(grid[currX][currY]);
            int X = currVal > 2 ? getDirection(currVal) : 0;
            int Y = currVal <= 2 ? getDirection(currVal) : 0;
            for (int[] dir : direction) {
                int nx = currX + dir[0];
                int ny = currY + dir[1];
                if (!isValid(nx, ny, n, m)) {
                    continue;
                }
                int newC = dir[0] == X && dir[1] == Y ? 0 + currC : 1 + currC;
                if (newC < vis[nx][ny]) {
                    pq.add(new int[] { nx, ny, newC });
                    vis[nx][ny] = newC;
                }
            }
        }
        return -1;
    }
}
