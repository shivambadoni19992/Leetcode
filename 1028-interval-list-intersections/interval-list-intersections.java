class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int maxStart = Math.max(secondList[j][0], firstList[i][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);
            if (maxStart <= endMin) {
                ans.add(new int[] { maxStart, endMin });
            }
            if (endMin == firstList[i][1]) i++; else j++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
