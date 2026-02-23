class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> permutations = new HashSet<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        int count = 0;
        for (List<Integer> perm : permutations) {
            if (isSquareful(perm))
                count++;
        }
        return count;
    }

    private void generatePermutations(int[] nums, List<Integer> current, boolean[] used, Set<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                if (current.size() > 0 && !isPerfectSquare(current.get(current.size() - 1) + nums[i]))
                    continue;
                used[i] = true;
                current.add(nums[i]);
                generatePermutations(nums, current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    private boolean isSquareful(List<Integer> perm) {
        for (int i = 0; i < perm.size() - 1; i++) {
            if (!isPerfectSquare(perm.get(i) + perm.get(i + 1)))
                return false;
        }
        return true;
    }

    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    
}