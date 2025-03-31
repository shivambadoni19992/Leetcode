class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> container = new PriorityQueue<>(Collections.reverseOrder());
        int stationCount = 0, petR = startFuel, prevS = 0;
        for (int i = 0; i < stations.length; i++) {
            int currStation = stations[i][0];
            int currFuel = stations[i][1];
            petR = petR - (currStation - prevS);
            while (!container.isEmpty() && petR < 0) {
                petR += container.poll();
                stationCount++;
            }
            if (petR < 0) return -1;
            prevS = currStation;
            container.add(currFuel);
        }
        petR = petR - (target - prevS);
        while (!container.isEmpty() && petR < 0) {
            petR += container.poll();
            stationCount++;
        }
        if (petR < 0) return -1;
        return stationCount;
    }
}
