class Solution {
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        
        for(int i=1; i<=9; i++)solve(i,1,n,k);
        
        int len = res.size();
        int[] arr  = new int[len];
        for(int i=0; i<len; i++)arr[i] = res.get(i);
        return arr;
    }
    
    private void solve(int item, int i, int n, int k){
        if(i==n){
            res.add(item);
            return;
        }
        
        int a = item % 10;
        
        if(k == 0){
            int temp = (item*10) + a;
            solve(temp,i+1,n,k);
        }
        else{
            
            if((a+k)<=9){
                int temp = (item*10) + (a+k);
                solve(temp,i+1,n,k);
            }
            if((a-k)>=0){
                int temp = (item*10) + (a-k);
                solve(temp,i+1,n,k);
            }    
        }
        
    }
}
