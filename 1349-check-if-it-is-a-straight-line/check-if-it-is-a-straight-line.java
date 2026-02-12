class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];

        for(int i = 2; i  < coordinates.length; i++) {
            int x1 = coordinates[i][0] - coordinates[i - 1][0];
            int y1 = coordinates[i][1] - coordinates[i - 1][1];

            if(x * y1 != y * x1) return false;
        }
        return true;
    }
}