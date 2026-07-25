class Solution {
    public int maxDigitRange(int[] nums) {
        

        int range[] = new int[nums.length];
        int largest = 0;
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int max = 0;
            int min = 9;
            while(n > 0) {
                int rem = n % 10;
                n = n / 10;
                min = Math.min(min, rem);
                max = Math.max(max, rem);
            }

            largest = Math.max(largest,  max - min);
            range[i] = max - min;
        }
        
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(range[i] == largest) {
                sum += nums[i];
            }
        }
        return sum;
    }
}