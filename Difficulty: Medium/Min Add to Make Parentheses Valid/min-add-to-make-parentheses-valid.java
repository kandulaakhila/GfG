class Solution {
    public int minParentheses(String s) {
        Stack<Character>stack=new Stack<>();
        int insertions=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    insertions++;
                }
            }
        }
        return insertions+stack.size();
    }
}