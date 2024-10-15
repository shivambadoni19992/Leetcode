class Solution {

    public int convertToMinutes(String a, String b) {
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        System.out.println(num1);
        return num1 * 60 + num2;
    }

    public int numberOfRounds(String loginTime, String logoutTime) {
        // 9*60+31=571/15;
        // 10*60+14=614/15;
        // 1> 38 rem=1
        // 2> 40
        // int a = String.atoi()[0]);
        String arr1[] = loginTime.split(":");
        String arr2[] = logoutTime.split(":");
        int a = convertToMinutes(arr1[0], arr1[1]);
        int b = convertToMinutes(arr2[0], arr2[1]);
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
