class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) return (long) s;

        long sum = 0;
        long add = (long) m * ((long)n / 2);
        long sub = (long) n / 2 - 1;
        sum = (long) s + add - sub;
        return sum;

        
    }
}