class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int answer[] = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int left = bookings[i][0];

            int right = bookings[i][1];
            int sum = bookings[i][2];
            answer[left - 1] += sum;
            if (right < n) answer[right] += -sum;
        }

        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}
