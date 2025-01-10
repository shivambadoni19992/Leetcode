class Solution {

    public boolean dfs(ArrayList<Integer>[] vertices, int source, int destination, boolean[] visited) {
        if (source == destination) return true;
        visited[source] = true;
        for (int i = 0; i < vertices[source].size(); i++) {
            int edge = vertices[source].get(i);
            if (!visited[edge]) {
                if (dfs(vertices, edge, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] vertices = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            vertices[start].add(end);
            vertices[end].add(start);
        }
        return dfs(vertices, source, destination, new boolean[n]);
    }
}
