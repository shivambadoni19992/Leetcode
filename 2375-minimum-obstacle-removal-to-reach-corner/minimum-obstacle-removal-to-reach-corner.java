class Pair {
    int a, b;
    
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Count implements Comparable<Count> {
    int count;
    Pair pair;

    Count(int count, Pair pair) {
        this.count = count;
        this.pair = pair;
    }

    @Override
    public int compareTo(Count other) {
        return Integer.compare(this.count, other.count);
    }
}

class Solution {

    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Count> minPQ = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        Pair check = new Pair(0, 0);
        Count inp = new Count(grid[0][0], check);
        minPQ.add(inp);
        int count;
        while (!minPQ.isEmpty()) {
            Count c = minPQ.poll();
            Pair border = c.pair;
            if (border.a == n - 1 && border.b == m - 1) {
                return c.count;
            }
            if (visited[border.a][border.b]) continue;
            visited[border.a][border.b] = true;
            if (border.a - 1 >= 0) {
                Pair chec = new Pair(border.a - 1, border.b);
                Count in = new Count(grid[border.a - 1][border.b] + c.count, chec);
                minPQ.add(in);
            }
            if (border.a + 1 < n) {
                Pair chec = new Pair(border.a + 1, border.b);
                Count in = new Count(grid[border.a + 1][border.b] + c.count, chec);
                minPQ.add(in);
            }
            if (border.b - 1 >= 0) {
                Pair chec = new Pair(border.a, border.b - 1);
                Count in = new Count(grid[border.a][border.b - 1] + c.count, chec);
                minPQ.add(in);
            }
            if (border.b + 1 < m) {
                Pair chec = new Pair(border.a, border.b + 1);
                Count in = new Count(grid[border.a][border.b + 1] + c.count, chec);
                minPQ.add(in);
            }
        }
        return -1;
    }
}
