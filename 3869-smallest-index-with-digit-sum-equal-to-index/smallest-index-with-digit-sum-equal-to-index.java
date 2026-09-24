class Solution {

    int digitSum(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem;
            num/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(digitSum(nums[i]) == i) return i;
        }
        return -1;
    }
}