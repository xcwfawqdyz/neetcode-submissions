class Solution {

    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()|| stack.peek()!=map.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
                
            }
        }
        return stack.isEmpty();
    }
}
