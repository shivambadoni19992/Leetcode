class Solution {
    public long minEnd(int n, int x) {
        int temp = x;
        int temp1 = n - 1;
        long ans = 0;
        long left_shift = 1;
        int one = 1;
        while(temp > 0 || temp1 > 0){
            
            if((temp & 1) == 1){
                ans = ans | left_shift;
            } else {
                int left = 0;
                if((temp1&1)==1){
                    ans = ans | left_shift;
                }
                
                temp1 = temp1 >> 1;
            }
            temp = temp >> 1;
            left_shift = left_shift << 1;
            
        }

        return ans;
    }
}