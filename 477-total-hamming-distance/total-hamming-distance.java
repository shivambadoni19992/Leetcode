class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int ones = 0,zeroes = 0;
            int x = (1<<i);
            for(int j=0;j<nums.length;j++){
                if((nums[j]&x)==x)
                    ones++;
                if((nums[j]&x)==0)
                    zeroes++;
            }
            if(ones==nums.length || zeroes==nums.length)
                continue;
            else
                ans = ans+(ones*zeroes);
            
        }
        return ans;
    }
}