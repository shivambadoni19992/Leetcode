class Solution {
    int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int x1 = getDays(arriveAlice);
        int y1 = getDays(leaveAlice);
        int x2 = getDays(arriveBob);
        int y2 = getDays(leaveBob);
        if(y1 < x2 || y2 < x1) return 0;
        return Math.abs(Math.max(x1, x2)-Math.min(y1, y2))+1;
    }
    
    private int getDays(String str){
        int total = 0;
        int month = Integer.valueOf(str.substring(0,2));
        int days = Integer.valueOf(str.substring(3,5));
        for(int i=0;i<month-1;i++){
            total += daysOfMonth[i];
        }
        total += days;
        return total;
    }  
}