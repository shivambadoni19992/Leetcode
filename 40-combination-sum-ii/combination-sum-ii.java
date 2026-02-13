class Solution {
   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinations(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            if (target - candidates[i] >= 0) {
                current.add(candidates[i]);
                generateCombinations(candidates, target - candidates[i], i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
}