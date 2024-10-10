class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        for(int i = 0 ;i <strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i >= strs[j].length()) return strs[j];
                char ch = strs[j].charAt(i);
                if(ch != c) return ans; 
            }
            ans+=c;
        }
        return ans; 
    }
}