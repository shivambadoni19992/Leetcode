class Solution {
    public int maxSatisfaction(int[] satisfaction) {

        int totalSum = 0;
        int startTotal = 0;
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        for(int i = 0; i < n; i++) {
            startTotal += ((i + 1) * satisfaction[i]);
            totalSum += satisfaction[i];
        }

        int max = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, startTotal);
            startTotal -= totalSum;
            totalSum -= satisfaction[i];
        }
        return max;
        
    }
}