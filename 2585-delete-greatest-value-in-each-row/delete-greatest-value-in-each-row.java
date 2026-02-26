class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
        }
        
        int res = 0;
        for (int j = 0; j < m; j++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int i = 0; i < n; i++) {
                pq.add(grid[i][j]);
            }
            res += pq.poll();
        }
        
        return res;
    }
}