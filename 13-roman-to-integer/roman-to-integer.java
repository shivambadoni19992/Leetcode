class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int n = 0;
        int max = 0;
        for(int i = s.length() -1 ;i>=0;i--) {
            int num = map.get(s.charAt(i));
            if(num < max) {
                n -= num;
            } else{
                n +=num;
                max=num;
            }
        }
        return n;
       
    }
}