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
                size[parV] += size[parV];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> emailParent = new HashMap<>();

        for(int v = 0; v < n; v++) {
            List<String> account = accounts.get(v);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if(emailParent.containsKey(email)) {
                    ds.unionBySize(emailParent.get(email), v);
                    continue;
                }
                emailParent.put(email, v);
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();

        for(String email : emailParent.keySet()) {
            int currPar = emailParent.get(email);
            int parent = ds.findPar(currPar);
            merged.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(merged.containsKey(i)) {
                List<String> account = new ArrayList<>();
                account.add(accounts.get(i).get(0));
                List<String> sorted = merged.get(i);
                Collections.sort(sorted);
                for(String email : sorted) {
                    account.add(email);
                }
                ans.add(account);
            }
        }
        return ans;
    }
}