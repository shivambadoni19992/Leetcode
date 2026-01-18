class Solution {

    class DisjointSet {
        int parent[];
        int size[];
        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findPar(int u) {
            if(parent[u] == u) return u;
            return parent[u] = findPar(parent[u]);
        }
        void unionBySize(int u, int v) {
            int parU = findPar(u);
            int parV = findPar(v);
            if(parU == parV) return;
            if(size[parU] >= size[parV]) {
                parent[parV] = parU;
                size[parU] += size[parV];
            } else {
                parent[parU] = parV;
                size[parV] += size[parU];
            }
        }
        int findMax() {
            int max = 0;
            for(int i = 0; i < parent.length ; i++) {
                max = Math.max(size[i], max);
            }
            return max;
        }
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        Map<Integer, Integer> par = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(par.containsKey(num)) continue;
            if(par.containsKey(num - 1)) {
                ds.unionBySize(par.get(num - 1), i);
            }
            if(par.containsKey(num + 1)) {
                ds.unionBySize(par.get(num + 1), i);
            }
            par.put(num, i);
        }
        return ds.findMax();
    }
}