class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();

        Set<Long> active = new HashSet<>();

        for (int[] l : lamps) {
            int r = l[0], c = l[1];
            long key = (long) r * n + c;

            if (active.contains(key)) continue;
            active.add(key);

            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
            diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
        }

        int[][] dirs = {
            {0,0},{0,1},{1,0},{-1,0},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {

            int r = q[0], c = q[1];

            if (row.getOrDefault(r,0) > 0 ||
                col.getOrDefault(c,0) > 0 ||
                diag1.getOrDefault(r-c,0) > 0 ||
                diag2.getOrDefault(r+c,0) > 0)
                ans[idx++] = 1;
            else
                ans[idx++] = 0;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                long key = (long) nr * n + nc;

                if (!active.contains(key))
                    continue;

                active.remove(key);

                row.put(nr, row.get(nr) - 1);
                col.put(nc, col.get(nc) - 1);
                diag1.put(nr - nc, diag1.get(nr - nc) - 1);
                diag2.put(nr + nc, diag2.get(nr + nc) - 1);
            }
        }

        return ans;
    }
}