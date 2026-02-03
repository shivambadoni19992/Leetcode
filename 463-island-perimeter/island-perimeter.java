class Solution {
    public int islandPerimeter(int[][] grid) {

        Set<String> visLand = new HashSet<>();

        Queue<int[]> bfs = new LinkedList<>();

        int [][]directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    bfs.add(new int[]{i, j});
                    visLand.add(i + " " + j);
                    break;
                }
            }
            if(!bfs.isEmpty()) break;
        }

        int count = 0;
        while(!bfs.isEmpty()) {
            int curr[] = bfs.poll();

            for(int dir[] : directions) {
                int nx = dir[0] + curr[0];
                int ny = dir[1] + curr[1];


                if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                    count++;
                    continue;
                }

                if(grid[nx][ny] == 0) {
                    count++;
                } else {
                    if(!visLand.contains(nx + " " + ny)) {
                        visLand.add(nx + " " + ny);
                        bfs.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return count;
        
    }
}