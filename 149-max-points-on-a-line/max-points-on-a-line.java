class Solution {
    public int maxPoints(int[][] points) {

        
        int maxPoints = 0;
        
        for(int i = 0; i < points.length; i++) {
            float x1 = points[i][0];
            float y1 = points[i][1];
            int inf = 0;
            Map<Float, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                float x2 = points[j][0];
                float y2 = points[j][1];

                if(x1 == x2) {
                    inf++;
                    maxPoints = Math.max(inf, maxPoints);
                    continue;
                }

                float slope = (y2 - y1) / (float) (x2 - x1);
                
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                maxPoints = Math.max(maxPoints, map.get(slope));
            }

        }

        return maxPoints + 1;
        
    }
}