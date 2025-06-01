class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int a[] ,int b[]){
                return a[1] - b[1];
            }
        });
        for(int i =0;i< times.length;i++){
            int src = times[i][0];
            int dest = times[i][1];
            int time = times[i][2];
            if(!adj.containsKey(src)) {
                adj.put(src,new ArrayList<>());
            }
            adj.get(src).add(new int[]{dest,time});
        }
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{k,0});
        int minTime = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int cs = curr[0];
            int ct = curr[1];
            if(!visited.contains(cs)) {
                minTime = Math.max(ct , minTime);
                visited.add(cs);
                if(adj.containsKey(cs)){
                    ArrayList<int[]> destList = adj.get(cs);
                    for(int i =0;i < destList.size();i++){
                        pq.add(new int[]{destList.get(i)[0],ct + destList.get(i)[1]});
                    }
                }
            }
        }
        if(visited.size() != n) return -1;
        return minTime;

    }
}