class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int count_max = 1;
        if(nums.length==0) return 0;
        for (int i = 0 ;i < nums.length; i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],1);
            
            if(map.containsKey(nums[i]-1)) {
                map.put(nums[i],map.get(nums[i]-1) + map.get(nums[i]));
                // map.put(nums[i-1],map.get(nums[i]));
            }
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i],map.get(nums[i]+1) + map.get(nums[i]));
                // map.put(nums[i]+1,map.get(nums[i]));
            }
            if(map.containsKey(nums[i]-1)) {
                map.put(nums[i] - map.get(nums[i]-1),map.get(nums[i]));
            }
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i] + map.get(nums[i]+1),map.get(nums[i]));
            }
            count_max = Math.max(count_max,map.get(nums[i]));
        }
        return count_max;
    }
}