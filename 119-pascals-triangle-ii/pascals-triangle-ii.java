class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) temp.add(1);
                else temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            ans.add(temp);
        }
        return ans.size() == 0 ? new ArrayList() : ans.get(ans.size()-1);
    }
}