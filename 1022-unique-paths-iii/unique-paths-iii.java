class Solution {
    int pathCount = 0, countZero = 1;

    public void dfs(int grid[][], int startX, int startY) {
        if (startX < 0 || startX >= grid.length || startY < 0 || startY >= grid[0].length || grid[startX][startY] == -1) {
            return;
        }
        if (grid[startX][startY] == 2) {
            if (countZero == 0) pathCount++;
            return;
        }
        grid[startX][startY] = -1;
        countZero--;
        dfs(grid, startX + 1, startY);
        dfs(grid, startX - 1, startY);
        dfs(grid, startX, startY + 1);
        dfs(grid, startX, startY - 1);
        grid[startX][startY] = 0;
        countZero++;
    }

    public int uniquePathsIII(int[][] grid) {
        int startX = -1, startY = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    countZero++;
                }
            }
        }
        dfs(grid, startX, startY);
        return pathCount;
    }
}
