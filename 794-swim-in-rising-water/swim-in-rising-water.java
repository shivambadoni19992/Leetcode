class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int directions[][] = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        pq.add(new int[]{0, 0, grid[0][0]});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int t = curr[2];
            grid[row][col] = -1;
            time = Math.max(time, t);
            if(row == n - 1 && col == n - 1) return time;

            for(int []dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] != -1) {
                    pq.add(new int[]{newRow, newCol, grid[newRow][newCol]});
                }
            }

        }
        return time;
    }
}