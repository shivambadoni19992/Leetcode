class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        int []indegree = new int[numCourses];
        Set<Integer>[] result = new HashSet[numCourses];
        Queue<int[]> queue = new LinkedList<>();

        for(int prereq[] : prerequisites) {
            int from = prereq[0];
            int to = prereq[1];
            if(!adj.containsKey(from)) {
                adj.put(from , new ArrayList<>());
            }

            adj.get(from).add(to);
            indegree[to]++;
        }

        for(int i = 0;i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(new int[] { i ,0});
            }
            result[i] = new HashSet<>();
        }
    
        while(!queue.isEmpty()) {
            int []currNode = queue.poll();
            int curr = currNode[0];
            int level = currNode[1];
            
            for(int child : adj.getOrDefault(curr ,new ArrayList<>())) {
                indegree[child]--;
                result[child].add(curr);
                result[child].addAll(result[curr]);
                if(indegree[child] == 0) {
                    queue.offer(new int[] { child, level + 1});
                }                
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int []query : queries) {
            int u = query[0];
            int v = query[1];
            ans.add(result[v].contains(u));
        }
        return ans;
    }
}