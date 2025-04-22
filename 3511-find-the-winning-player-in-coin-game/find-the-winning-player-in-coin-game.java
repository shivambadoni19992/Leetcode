class Solution {

    public String winningPlayer(int x, int y) {
        int turns = Math.min(x, y / 4);
        if (turns % 2 == 0) return "Bob";
        return "Alice";
    }
}
