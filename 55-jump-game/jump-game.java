class Solution {
    public boolean canJump(int[] nums) {

        int maxJumpInd = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            int nextInd = i + nums[i];

            maxJumpInd = Math.max(maxJumpInd, nextInd);
            if(maxJumpInd == i) return false;
        }
        return true;

        
    }
}