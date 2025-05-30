class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        int dir[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        boolean vis[][] = new boolean[image.length][image[0].length];
        vis[sr][sc] = true;

        while(!q.isEmpty()) {
            int pos[] = q.poll();
            for(int d[] : dir) {
                int row = pos[0] + d[0];
                int column = pos[1]+d[1];
                if(row >=0 && row < image.length && column>=0 && column < image[0].length && image[row][column] == currColor && !vis[row][column]) {
                    q.add(new int[]{row,column});
                    image[row][column] = color;
                    vis[row][column] = true;
                }
            }
        }
        return image;
    }
}