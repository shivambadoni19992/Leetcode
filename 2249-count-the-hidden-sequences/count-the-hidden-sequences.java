class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;
        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long range = (long)upper - lower;
        long validRange = range - (max - min) + 1;
        if(validRange < 0) return 0;
        
        return (int)validRange;
    }
}
