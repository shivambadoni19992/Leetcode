class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        long start = 1, end = target;
        long moves = 0;
        long finalPos = 0;

        while(start <= end) {
            long mid = start + (end - start) / 2;

            long sum = (mid * (mid + 1)) / 2;

            if(sum >= target) {
                moves = mid;
                finalPos = sum;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int differ = (int) (finalPos - target);

        if(differ % 2 != 0) {
            if((moves + 1) % 2 != 0){
                moves += 1;
            }
            else{
                moves += 2;
            }  
        }
        return (int) moves;
    }
}