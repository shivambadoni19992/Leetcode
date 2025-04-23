class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        int answer[] = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int from = trips[i][1];
            int to = trips[i][2];
            int passenger = trips[i][0];
            answer[from] += passenger;
            answer[to] += -passenger;
        }
        if(answer[0] > capacity) return false;
        for (int i = 1; i < 1001; i++) {
            answer[i] += answer[i - 1];
            if (answer[i] > capacity) return false;
        }
        return true;
    }
}
