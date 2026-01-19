class Solution {
    int getNextDay(int ind, int[] days, int duration) {
        int limit = days[ind] + duration;
        while (ind < days.length && days[ind] < limit) {
            ind++;
        }
        return ind;
    }

    int helper(int ind, int days[], int costs[], int dp[]) {
        if(ind >= days.length) return 0;
        if(dp[ind] != -1) return dp[ind];

        int getday1 = getNextDay(ind, days, 1);
        int getday7 = getNextDay(ind, days, 7);
        int getday30 = getNextDay(ind, days, 30);

        int day1 = costs[0] + helper(getday1, days, costs, dp);
        int day7 = costs[1] + helper(getday7, days, costs, dp);
        int day30 = costs[2] + helper(getday30, days, costs, dp);
        // return day7;
        return dp[ind] = Math.min(day1, Math.min(day7, day30));
    }
    public int mincostTickets(int[] days, int[] costs) {

        int dp[] = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(0, days, costs, dp);
    }
}