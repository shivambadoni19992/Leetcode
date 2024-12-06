class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<banned.length;i++){
            map.put(banned[i],i);
        }
        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if(!map.containsKey(i)){
                sum+=i;
                if (sum > maxSum) return count;
                count++;
            }
            
        }
        return count;
    }
}
