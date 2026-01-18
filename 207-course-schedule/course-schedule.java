class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int inDegree[] = new int[numCourses];
        for(int []pre : prerequisites) {
            int course1 = pre[0];
            int course2 = pre[1];
            adj.computeIfAbsent(course2, k -> new ArrayList<>()).add(course1);
            inDegree[course1]++;
        } 
        List<Integer> completedCourse = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            completedCourse.add(curr);

            if(adj.containsKey(curr)) {

                for(int course : adj.get(curr)) {
                    inDegree[course]--;
                    if(inDegree[course] == 0) {
                        q.add(course);
                    }
                }
            }
        }
        return completedCourse.size() == numCourses;


    }
}