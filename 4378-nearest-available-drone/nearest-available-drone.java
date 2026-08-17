class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int index = -1;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < drones.length; i++) {
            int x = Math.abs(drones[i][0] -  target[0]);
            int y = Math.abs(drones[i][1] -  target[1]);

            if(x + y <= drones[i][2] && x + y < prev) {
                index = i;
                prev = x + y;
            }
        }
        return index;
    }
}