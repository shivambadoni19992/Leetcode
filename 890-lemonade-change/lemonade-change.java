class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for(int bill : bills) {
            int balance = (bill - 5);

            if(balance == 15) {
                if(tens >= 1) {
                    tens--;
                    balance = balance - 10;
                }
            }
            if(balance != 0) {
                if(fives < (balance / 5)) return false;
                fives = fives - (balance / 5);
            } 

            if(bill == 5) fives++;
            else if(bill == 10) tens++;
        }
        return true;
    }
}