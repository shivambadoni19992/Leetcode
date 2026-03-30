class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean ans=false;
        if(s1.length()>s2.length()) return ans;
        int[] countS1=new int[26];
        for(int i=0;i<s1.length();i++){
            countS1[s1.charAt(i)-'a']++;
        }
        int[] countS2=new int[26];
        for(int i=0,j=0;j<s2.length();j++){
            countS2[s2.charAt(j)-'a']++;
            if(j-i+1==s1.length()){
                if(Arrays.equals(countS1,countS2)) return true;
                countS2[s2.charAt(i)-'a']--;
                i++;
            }
        }
        return ans;
    }
}