
class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int maxScore = 0;
        int score = 0;
        while (i <= j) {
            if (i==j && power<tokens[i]){
                return maxScore;
            }
            if (power>=tokens[i]){
                power -= tokens[i];
                i+=1;
                score +=1;
                maxScore = Math.max(maxScore, score);
                continue;
            } 
            if (power<tokens[j]){
                power += tokens[j];
                j-=1;
                score -=1;
                maxScore = Math.max(maxScore, score);
                if (score<0){
                    return 0;
                }
            }
            
        }
        return maxScore;
    }
}
