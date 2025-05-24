class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<>() {

                @Override
                public int compare(int[] a, int b[]) {
                    return b[1] - a[1];
                }
            }
        );
        for (int key : map.keySet()) {
            int val = map.get(key);
            pq.add(new int[] { key, val });
        }
        int i = 0;
        while (k > i) {
            ans[i++] = pq.poll()[0];
        }
        return ans;
    }
}
