class Solution {

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long h = l * n;
        long gcd = gcd(a, b);
        long lcm = (a * b) / gcd;
        while (l < h) {
            long mid = l + (h - l) / 2;
            long factor = mid / a + mid / b - mid / lcm;
            if (factor < n) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        int mod = (int) (1e9 + 7);
        return (int) (l % mod);
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}