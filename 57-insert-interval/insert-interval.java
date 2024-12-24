class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();
        int i = 0 ;
        int n= intervals.length;
        while(i<n && intervals[i][1] < newInterval[0]){
            arr.add(intervals[i]);
            i++;
        } 
        
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        arr.add(newInterval);

        while(i<n) arr.add(intervals[i++]);
        int [][] res = new int[arr.size()][2];
        int c = 0;
        for(int []a : arr){
            res[c][0] = a[0];
            res[c][1] = a[1];
            c++;
        }
        return res;
    }
}