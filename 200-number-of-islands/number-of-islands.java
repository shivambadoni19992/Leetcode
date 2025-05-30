class Solution {

    public int numIslands(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    q.add(new int[] { i, j });
                    grid[i][j] = '0';
                    count++;
                    while (!q.isEmpty()) {
                        int a[] = q.poll();
                        int first = a[0];
                        int second = a[1];
                        for (int[] dir : directions) {
                            int newRow = first + dir[0];
                            int newCol = second + dir[1];
                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1') {
                                q.add(new int[] { newRow, newCol });
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
