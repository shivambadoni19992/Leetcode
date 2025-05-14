class Solution {

    public int getLength(String s, char c, int k) {
        int tempK = k;
        int max = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) != c) {
                tempK--;
                while (i < j && tempK < 0) {
                    if (s.charAt(i) != c) {
                        tempK++;
                    }
                    i++;
                }
            }
            j++;
            max = Math.max(max, j - i);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = getLength(answerKey, 'T', k);
        int maxF = getLength(answerKey, 'F', k);
        return Math.max(maxF, maxT);
    }
}
