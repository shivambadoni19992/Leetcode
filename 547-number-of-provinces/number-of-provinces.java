class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int findParent(int u) {
        if (parent.get(u) == u) return u;
        int i = findParent(parent.get(u));
        parent.set(u, i);
        return parent.get(u);
    }

    void findUnionBySize(int u, int v) {
        int ult_u = findParent(u);
        int ult_v = findParent(v);
        if (ult_u == ult_v) return;
        if (size.get(ult_u) < size.get(ult_v)) {
            parent.set(ult_u, ult_v);
            size.set(ult_v, size.get(ult_u) + size.get(ult_v));
        } else {
            parent.set(ult_v, ult_u);
            size.set(ult_u, size.get(ult_u) + size.get(ult_v));
        }
    }
}

class Solution {

    public int findCircleNum(int[][] isConnected) {
        DisjointSet ds = new DisjointSet(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    ds.findUnionBySize(i + 1, j + 1);
                }
            }
        }
        int count = 0;
        for (int i = 1; i < ds.parent.size(); i++) {
            if (ds.parent.get(i) == i) count++;
        }
        return count;
    }
}
