class Solution {

    class DisjointSet {
        Map<Integer, Integer> comp = new HashMap<>();

        Map<Integer, Integer> par = new HashMap<>();

        public DisjointSet() {

        }

        void setPar(int u) {
            par.put(u, u);
        }


        boolean contains(int u) {
            return par.containsKey(u);
        }

        int findPar(int u) {
            if(par.get(u) == u) return u;
            par.put(u, findPar(par.get(u)));
            return par.get(u);
        }

        void union(int u, int v) {
            int parU = findPar(u);
            int parV = findPar(v);

            if(parU == parV) return;

            int sizeU = comp.getOrDefault(parU, 1);
            int sizeV = comp.getOrDefault(parV, 1);
            int newSize = sizeU + sizeV;
            if(sizeU <= sizeV) {
                par.put(parU, parV);
                comp.put(parV, newSize);
            } else {
                par.put(parV, parU);
                comp.put(parU, newSize);
            }
        }

        int findMax() {
            int max = 0;
            for(int key : par.keySet()) {
                if(par.get(key) == key) {
                    max = Math.max(max, comp.getOrDefault(key, 1));
                }
            }
            return max;
        }
    }
    public int longestConsecutive(int[] nums) {
        DisjointSet dsu = new DisjointSet();

        for(int num : nums) {
            if(dsu.contains(num)) continue;

            dsu.setPar(num);

            if(dsu.contains(num - 1)) {
                dsu.union(num, num - 1);
            }

            if(dsu.contains(num + 1)) {
                dsu.union(num, num + 1);
            }
        }
        return dsu.findMax();
    }
}