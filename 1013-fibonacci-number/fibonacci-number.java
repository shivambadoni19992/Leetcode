class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int first = 0, second = 1;
        int ans = 0;
        for(int i = 2;i <= n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
        
    }
}