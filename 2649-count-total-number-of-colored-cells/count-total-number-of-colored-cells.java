class Solution {
    public long coloredCells(int n) {
        long m = (long)(n);
        return (m*m)+((m-1)*(m-1));
    }
}