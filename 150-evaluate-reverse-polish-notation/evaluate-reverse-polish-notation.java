class Solution {
    public int convert(String a){
        int num=1,i=0;
        if(a.charAt(0)=='-') {
            num=-1;
            i++;
        }
        int sum=0;
        while(i<a.length()){
            sum = sum*10 + (a.charAt(i)-'0');
            i++;
        }
        return sum * num;

    }
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            // String ch = "";
            // ch += tokens[i];
            int a,b,sum;
            switch(tokens[i]){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    sum = b + a;
                    stack.push(sum);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    sum = b - a;
                    stack.push(sum);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    sum = b * a;
                    stack.push(sum);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    sum = b / a;
                    stack.push(sum);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}