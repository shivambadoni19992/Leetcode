class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int rev = 0;
        if(x < 0) {
            x = x * (-1);
            negative = true;
        }
        while(x > 0){
            int mod = x % 10;
            rev = rev * 10 + mod;
            x = x / 10; 
            if (rev > Integer.MAX_VALUE / 10 && x != 0) return 0;
        }
        return negative ? rev * (-1) : rev;
        
    }
}