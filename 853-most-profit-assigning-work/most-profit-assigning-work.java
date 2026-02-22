class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] ans = new int[n][2];

        for(int i = 0; i < n; i++) {
            ans[i][0] = difficulty[i];
            ans[i][1] = profit[i];
        }

        Arrays.sort(ans, (a, b) -> a[0] - b[0]);

        for(int i = 1; i < n; i++) {
            ans[i][1] = Math.max(ans[i][1], ans[i - 1][1]);
        }
        int total = 0;
        for(int i = 0; i < worker.length; i++) {
            int t = worker[i];

            int start = 0, end = n - 1;

            int res = -1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                
                if(ans[mid][0] <= t) {
                    start = mid + 1;
                    res = mid;
                } else {
                    end = mid - 1;
                }
            }
            if(res != -1) total += ans[res][1];
        }
        return total;


    }
}