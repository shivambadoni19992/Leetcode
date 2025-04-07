class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(
            points,
            new Comparator<int[]>() {

                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[1], b[1]);
                }
            }
        );
        int maxEnd = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > maxEnd) {
                count++;
                maxEnd = points[i][1];
            }
        }
        return count;
    }
}
