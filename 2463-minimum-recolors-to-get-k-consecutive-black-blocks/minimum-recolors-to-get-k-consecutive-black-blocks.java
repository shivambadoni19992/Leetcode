class Solution {

    public int minimumRecolors(String blocks, int k) {
        int recolor = Integer.MAX_VALUE, colorW = 0, left = 0, right = 0;
        while (right < blocks.length()) {
            if (blocks.charAt(right) == 'W') colorW++;
            if (right - left + 1 == k) {
                recolor = Math.min(recolor, colorW);
                if (blocks.charAt(left) == 'W') colorW--;
                left++;
            }
            right++;
        }
        return recolor;
    }
}
