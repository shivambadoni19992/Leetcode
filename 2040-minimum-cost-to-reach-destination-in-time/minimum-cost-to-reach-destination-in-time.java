class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int target = passingFees.length;
        Map<Integer,ArrayList<int []>> map = new HashMap<>();
        for(int []edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1] , edge[2] });
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0] , edge[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int []a,int []b){
                return (a[1] == b[1]) ? (a[2] - b[2]) : (a[1] - b[1]);
            }
        });
        pq.add(new int[]{0, passingFees[0] , 0});
        
        int[] minTime = new int[target];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;
        target--;
        while(!pq.isEmpty()){
            int []edg = pq.poll();
            int dest = edg[0];
            int cost = edg[1];
            int time = edg[2];
            if(target == dest) return cost;
            if(time > maxTime) continue;
            for (int[] neighbor : map.getOrDefault(dest, new ArrayList<>())) {
                int next = neighbor[0], travelTime = neighbor[1];
                int newTime = time + travelTime;
                int newCost = cost + passingFees[next];

                if (newTime <= maxTime && newTime < minTime[next]) {
                    minTime[next] = newTime;
                    pq.offer(new int[]{next, newCost, newTime});
                }
            }

        }
        return -1;
    }
}