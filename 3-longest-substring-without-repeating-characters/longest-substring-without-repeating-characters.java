class Solution {
    public int lengthOfLongestSubstring(String s) {
        int end = 0 , start = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>(); 
        int length = s.length();
        while(end < length) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                map.put(ch , map.get(ch)+1);
                while(map.get(ch)>1){
                    char ch1 = s.charAt(start);
                    map.put(ch1,map.get(ch1)-1);
                    start++;
                }
            }else{
                map.put(ch , 1);
            }
            end++;
            max = Math.max(max,end-start);
        }
        return max;

    }
}