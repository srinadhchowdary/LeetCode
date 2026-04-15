class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        int x=0;
        int startIndex = 0;
        Stack<String> stk = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                x++;
            }
            else{
                x--;
                if(x == 0){
                    stk.push(s.substring(startIndex, i+1));
                    startIndex = i+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String ss:stk){
            StringBuilder s1 = new StringBuilder(ss);
            if(s1.length() > 1){
                s1.deleteCharAt(0);
                s1.deleteCharAt(s1.length()-1);
                sb.append(s1);
            }
        }

        return sb.toString();
    }
}