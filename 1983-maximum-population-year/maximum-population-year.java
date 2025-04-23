class Solution {

    public int maximumPopulation(int[][] logs) {
        int answer[] = new int[102];
        for (int i = 0; i < logs.length; i++) {
            int left = logs[i][0] - 1949;
            int right = logs[i][1] - 1949;
            answer[left]++;
            answer[right]--;
        }
        int max = Integer.MIN_VALUE;
        int year = 0;
        for (int i = 1; i < answer.length; i++) {
            answer[i] += answer[i - 1];
            if (answer[i] > max) {
                year = i;
                max = answer[i];
            }
        }
        return year + 1949;
    }
}
