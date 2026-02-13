class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int []inDegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int []edge : edges) {
            int u = edge[0];
            int v = edge[1];
            inDegree[v]++;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Queue<Integer> q = new LinkedList<>();

        Set<Integer>[] anc = new HashSet[n];

        for(int i = 0; i < inDegree.length; i++) {
            anc[i] = new HashSet<>();
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();

            if(adj.containsKey(curr)) {
                for(int node : adj.get(curr)) {
                    inDegree[node]--;

                    anc[node].add(curr);
                    anc[node].addAll(anc[curr]);

                    if(inDegree[node] == 0) {
                        q.add(node);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

       for(Set<Integer> set : anc) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}