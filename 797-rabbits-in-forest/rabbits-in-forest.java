class Solution {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            int groupSize = key + 1;
            int freq = map.get(key);
            int groups = (freq + groupSize - 1) / groupSize;
            count += groups * groupSize;
        }
        return count;
    }
}
