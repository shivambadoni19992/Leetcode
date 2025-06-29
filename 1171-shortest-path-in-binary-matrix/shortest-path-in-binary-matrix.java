class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;
       Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0,0,1});
        int directions[][] = new int[][]{ {0,1}, {1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currD = curr[2];
            if(currR == n -1 && currC == m -1){
                return currD;
            }
            for(int []dir : directions){
                int newR = currR + dir[0];
                int newC = currC + dir[1];
                if(newR >=0 && newR < n && newC >=0 && newC < m && !vis[newR][newC] && grid[newR][newC] == 0){
                    pq.offer(new int[]{newR, newC ,currD + 1});
                    vis[newR][newC] = true;
                }
            }

        }
        return -1;
    }
}