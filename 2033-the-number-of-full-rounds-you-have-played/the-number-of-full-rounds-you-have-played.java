class Solution {

    public int convertToMinutes(String arr) {
        return Integer.parseInt(arr.substring(0, 2)) * 60
            + Integer.parseInt(arr.substring(3, 5));
    }

    public int numberOfRounds(String loginTime, String logoutTime) {
        // 9*60+31=571/15;
        // 10*60+14=614/15;
        // 1> 38 rem=1
        // 2> 40
        // int a = String.atoi()[0]);
        int a = convertToMinutes(loginTime);
        int b = convertToMinutes(logoutTime);
        if (b < a) {
            b = b + (24 * 60);
        }
        int diva = a / 15;
        int rem = a % 15;
        int divb = b / 15;
        int ans = rem == 0 ? divb - diva : divb - diva - 1;
        return ans == -1 ? 0 : ans;
    }
}
