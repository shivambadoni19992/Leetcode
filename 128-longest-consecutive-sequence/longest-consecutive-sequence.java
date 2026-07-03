class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int max = 0;

        for(int num : set) {
            if(!set.contains(num - 1)) {   // start of sequence
                int curr = num;
                int len = 1;

                while(set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                max = Math.max(max, len);
            }
        }

        return max;
    }
}