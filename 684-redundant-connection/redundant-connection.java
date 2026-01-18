class Solution {


    class DisjointSetUnion {

        int parent[];
        int size[];

        public DisjointSetUnion(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for(int i = 0; i <= n ; i++) {
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

            if(size[parU] > size[parV]) {
                parent[parV] = parU;
                size[parU] += size[parV]; 
            } else {
                parent[parU] = parV;
                size[parV] += size[parV];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int ans[] = new int[2];
        DisjointSetUnion dsu = new DisjointSetUnion(edges.length);
        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            if(dsu.findPar(u) == dsu.findPar(v)) {
                ans = edge;
                continue;
            }
            dsu.unionBySize(u, v);

        }
        return ans;
    }
}