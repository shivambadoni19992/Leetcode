class Solution {
    
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        boolean []prime = new boolean[33];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i * i <= 32; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= 32; j += i) {
                    prime[j] = false;
                }
            }
            
        }
        for(int i=left;i<=right;i++){
            int num = i;
            int count=0;
            while(num>0){
                int bit = num%2;
                if(bit==1){
                    count++;
                }
                num=num/2;
            }
            if(prime[count])ans++;
        }
        return ans;
    }
}