class Solution {
    public String reverseWords(String s) {
        String res = "";
        int end = s.length();
        for(int i=end-1;i>=0;i--){
            if(s.charAt(i)==' ') {
                if(end-1!=i){
                    res = res +" " + s.substring(i+1,end);
                } 
                end = i;
                continue;
            }
        }
        if(s.charAt(0)!=' '){
            res = res +" "+s.substring(0,end);
        }
        return res.trim();
        
    }
}