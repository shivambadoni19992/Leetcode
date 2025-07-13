class Solution {
    List<String> ans = new ArrayList<>();
    public void generate(int n,int open, int close,StringBuilder sb){
        if(n == close && n == open) {
            ans.add(new String(sb));
            return;
        }
        if(close < open) {
            sb.append(')');
            generate(n, open, close +1 , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open < n) {
            sb.append('(');
            generate(n, open + 1, close , sb);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }
    public List<String> generateParenthesis(int n) {
        generate(n,0,0, new StringBuilder());
        return ans;
    }
}