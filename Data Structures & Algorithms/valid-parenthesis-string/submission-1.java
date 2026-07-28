class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left=new Stack<Integer>();
        Stack<Integer> star=new Stack<Integer>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                left.push(i);
            }else if( ch==')'){
                if(left.isEmpty()){
                    if(star.isEmpty()){
                        return false;
                    }
                    star.pop();
                }else{
                    left.pop();
                }
            }else{
                star.push(i);
            }
        }
        while(!left.isEmpty()){
            int l=left.pop();
            int r=star.isEmpty()?-1:star.pop();
            if(l>r) return false;
        }
        return true;
    }
}
