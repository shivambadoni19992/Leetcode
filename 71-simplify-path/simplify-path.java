class Solution {
    public String simplifyPath(String path) {
        String []s = path.split("/");
        Stack<String> st = new Stack();
        for(String p : s){
            if(p.equals("") || p.equals(".")) {
                continue;
            } else if(p.equals("..")){
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.add(p);
            }
            System.out.println(p);
        }

        List<String> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i< list.size();i++){
            sb.append("/");
            sb.append(list.get(i));
            
        }

        
        return list.size()==0 ? "/" : sb.toString();
    }
}