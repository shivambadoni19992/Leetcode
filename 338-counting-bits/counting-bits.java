class Solution {
    public int[] countBits(int n) {
        int bits[] = new int[n+1];
        bits[0] = 0;
        if(n > 0) bits[1] = 1;
        for(int i = 2;i <= n;i++){
            if(i % 2 == 0) bits[i] =  bits[i/2];
            else bits[i] = bits[i-1] + 1;
        } 
        return bits;
    }
}