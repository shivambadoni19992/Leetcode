class NumMatrix {
    private final int[][] ps; // (n+1) x (m+1)

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = (n == 0) ? 0 : matrix[0].length;
        ps = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ps[i+1][j+1] = matrix[i][j] + ps[i][j+1] + ps[i+1][j] - ps[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ps[row2 + 1][col2 + 1]
             - ps[row1][col2 + 1]
             - ps[row2 + 1][col1]
             + ps[row1][col1];
    }
}