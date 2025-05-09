class Solution {
    List<String> ans = new ArrayList<>();

    public void generate(StringBuilder s, int open, int close, int n) {
        if (open == n && close == n) {
            ans.add(s.toString());
            return;
        }
        if (close < open) {
            s.append(')');
            generate(s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (open < n) {
            s.append('(');
            generate(s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);

        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), 0, 0, n);
        return ans;
    }
}
