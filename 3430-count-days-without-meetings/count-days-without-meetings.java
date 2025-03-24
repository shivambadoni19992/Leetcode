class Solution {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(
            meetings,
            new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            }
        );
        int totalDays = 0;
        int i = 0, endTime = 0;
        while (i < meetings.length) {
            int currentStart = meetings[i][0];
            int currentEnd = meetings[i][1];
            if (currentStart > (endTime + 1)) {
                totalDays += currentStart - (endTime + 1);
            }
            endTime = Math.max(currentEnd, endTime);
            i++;
        }
        totalDays += (days - endTime);
        return totalDays;
    }
}
