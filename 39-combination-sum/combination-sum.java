class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public void find(int []can ,int start ,int sum, int target, List<Integer> list) {
        if(sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }  
        if(sum > target) {
            return ;
        }
        for(int i = start;i < can.length;i++){
            list.add(can[i]);
            find(can,i,sum+can[i],target,list);
            list.remove(list.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates,0,0,target,new ArrayList<>());
        return ans;
    }
}