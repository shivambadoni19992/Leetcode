class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]distance = new int[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
            distance[i][i] = 0;
        }
    
        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            distance[u][v] = dist;
            distance[v][u] = dist;
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n; j++){
                for(int k = 0 ;k < n ;k++){
                    if(distance[j][i] != Integer.MAX_VALUE && distance[i][k] != Integer.MAX_VALUE){
                        distance[j][k] = Math.min(distance[j][k] , distance[j][i]+ distance[i][k]);
                        
                    }
                }
            }
        }
        int minReachable = n;
        int resultCity = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minReachable) {
                minReachable = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}