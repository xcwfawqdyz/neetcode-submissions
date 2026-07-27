class Solution {
    private Map<Integer,String> map=new HashMap<>(){{
        put(2,"abc");
        put(3,"def");
        put(4,"ghi");
        put(5,"jkl");
        put(6,"mno");
        put(7,"pqrs");
        put(8,"tuv");
        put(9,"wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()) return result;
        dfs(digits,0,"",result);
        return result;
    }
    private void dfs(String digits, int start ,String tmp,List<String> result){
        int n=digits.length();
        if(start==n){
            result.add(tmp);
            return;
        }
        for(char ch:map.get(digits.charAt(start)-'0').toCharArray()){
            dfs(digits,start+1,tmp+ch,result);
        }
    }

}
