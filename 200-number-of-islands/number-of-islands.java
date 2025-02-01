
class Solution {
    
    // Directions for moving up, down, left, right
    private final int[] directions = {-1, 0, 1, 0, -1, 0};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;       // Number of rows
        int m = grid[0].length;    // Number of columns
        boolean[][] visited = new boolean[n][m];  // Visited array
        
        int count = 0; // Island count
        
        // BFS for each unvisited land cell ('1')
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If we find a land cell that hasn't been visited yet
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++; // New island found
                    bfs(grid, visited, i, j, n, m); // Perform BFS to mark all connected land
                }
            }
        }
        
        return count;
    }
    
    // Helper method to perform BFS and mark all connected land cells
    private void bfs(char[][] grid, boolean[][] visited, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];
            
            // Explore the 4 adjacent directions (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int newX = curX + directions[i];
                int newY = curY + directions[i + 1];
                
                // Check bounds and whether the cell is land and unvisited
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == '1' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
    }
}
