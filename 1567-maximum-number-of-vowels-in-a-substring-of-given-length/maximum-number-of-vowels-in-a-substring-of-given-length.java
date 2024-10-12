class Solution {
    public boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ;
    }
    public int maxVowels(String s, int k) {
        int max = 0,count = 0,i = 0,j = 0;
        while(j < k) {
            char ch = s.charAt(j);
            if(checkVowel(ch)) count++;
            System.out.println(count);
            max = Math.max(max,count);
            j++;
        }
        while(j % k < k && j < s.length()) {
            char ch = s.charAt(j);
            if(checkVowel(ch)) count++;
            char ch1 = s.charAt(i);
            if(checkVowel(ch1)) count--;
            max = Math.max(max,count);
            i++;
            j++;
        }
        return max;


    }
}