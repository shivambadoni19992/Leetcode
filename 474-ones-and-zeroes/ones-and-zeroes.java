class Solution {

    int helper(int ind, int [][]count01, int m, int n, Map<String, Integer> dp) {
        if(count01.length == ind) return 0;

        String key = ind + " " + m + " " + n;
        if(dp.containsKey(key)) return dp.get(key);
        int take = 0;
        if(count01[ind][0] <= m && count01[ind][1] <= n) {
            take = 1 + helper(ind + 1, count01, m - count01[ind][0], n - count01[ind][1], dp);
        }
        int notTake = helper(ind + 1, count01, m, n, dp);
        dp.put(key, Math.max(take, notTake));
        return Math.max(take, notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {

        int count01[][] = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for(char ch : strs[i].toCharArray()) {
                if(ch == '0') {
                    count0++;
                }  else {
                    count1++;
                }
            }
            count01[i][0] = count0;
            count01[i][1] = count1;

            
        }

        HashMap<String, Integer> dp = new HashMap<>();
        return helper(0, count01, m, n, dp);
        
    }
}