class Solution {
  
    public void find(int start,int []nums,List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
            if(i!=start&& nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            find(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(0,nums,list,ans);

        return ans;
    }
}