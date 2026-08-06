class Solution {
    public int smallestNumber(int n, int t) {

        for(int i = n; i <= 101; i++) {
            int dig = 1;

            int num = i;
            while(num > 0) {
                int rem = num % 10;
                num /= 10;
                dig *= rem;
            }
            if(dig % t == 0) return i;
        }
        return -1;
    }
}