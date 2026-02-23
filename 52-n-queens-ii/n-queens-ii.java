 class Solution {
    public int totalNQueens(int n) {
        int[] counter = new int[1];
        String[] temp = new String[n];
        Arrays.fill(temp, ".".repeat(n));
        int[] leftRow = new int[n];
        int[] lowerDiagnol = new int[2 * n - 1];
        int[] upperDiagnol = new int[2 * n - 1];
        helper(0, n, counter, temp, leftRow, lowerDiagnol, upperDiagnol);
        return counter[0];
    }
    
    private void helper(int col, int n, int[] counter, String[] temp, int[] left, int[] lower, int[] upper) {
        if (col == n) {
            counter[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == 0 && lower[i + col] == 0 && upper[n - 1 + col - i] == 0) {
                left[i] = 1;
                lower[i + col] = 1;
                upper[n - 1 + col - i] = 1;
                StringBuilder sb = new StringBuilder(temp[i]);
                sb.setCharAt(col, 'Q');
                temp[i] = sb.toString();
                
                helper(col + 1, n, counter, temp, left, lower, upper);
                left[i] = 0;
                lower[i + col] = 0;
                upper[n - 1 + col - i] = 0;
                sb.setCharAt(col, '.');
                temp[i] = sb.toString();
            }
        }
    }
}