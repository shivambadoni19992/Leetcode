class Solution {

    public int minOperations(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int sqrtSize = (int) Math.ceil(Math.sqrt(n));

        int sqrt[] = new int[sqrtSize];
        Arrays.fill(sqrt, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);

            sqrt[i / sqrtSize] = Math.min(sqrt[i / sqrtSize], nums[i]);
        }
        map.remove(0);
        int c = 0;
        for (int num : map.keySet()) {
            List<Integer> range = map.get(num);
            c++;
            for (int i = 0; i < range.size() - 1; i++) {
                int left = range.get(i);
                int right = range.get(i + 1);
                int leftGroup = (left / sqrtSize);
                int rightGroup = (right / sqrtSize);

                int leftPos = (leftGroup * sqrtSize) + (left % sqrtSize);
                int rightPos = (rightGroup * sqrtSize) + (right % sqrtSize);
                int minNum = num;
                if (leftGroup == rightGroup) {
                    for (int start = leftPos; start <= rightPos; start++) {
                        minNum = Math.min(minNum, nums[start]);
                    }
                } else {
                    for (int start = leftPos; start < ((leftGroup + 1) * sqrtSize); start++) {
                        minNum = Math.min(minNum, nums[start]);
                    }
                    for (int start = leftGroup + 1; start < rightGroup; start++) {
                        minNum = Math.min(minNum, sqrt[start]);
                    }
                    for (int start = (rightGroup * sqrtSize); start <= rightPos; start++) {
                        minNum = Math.min(minNum, nums[start]);
                    }
                }
                if (minNum != num) c++;
            }
        }
        return c;
    }
}
