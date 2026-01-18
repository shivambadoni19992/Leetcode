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
        int unionBySize(int u, int v) {
            int parU = findPar(u);
            int parV = findPar(v);
            if(parU == parV) return size[parU];
            if(size[parU] >= size[parV]) {
                parent[parV] = parU;
                size[parU] += size[parV];
                return size[parU];
            } else {
                parent[parU] = parV;
                size[parV] += size[parU];
                return size[parV];
            }
        }
        
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        DisjointSet ds = new DisjointSet(n);
        Map<Integer, Integer> par = new HashMap<>();
        int max = 1;
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(par.containsKey(num)) continue;
            if(par.containsKey(num - 1)) {
                max = Math.max(max, ds.unionBySize(par.get(num - 1), i));
            }
            if(par.containsKey(num + 1)) {
                max = Math.max(max, ds.unionBySize(par.get(num + 1), i));
            }
            par.put(num, i);
        }
        return max;
    }
}