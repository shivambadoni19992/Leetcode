class Solution {

    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPower = modPow(5, evenCount, mod);
        long oddPower = modPow(4, oddCount, mod);
        return (int) ((evenPower * oddPower) % mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
