class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int start=0,result=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                start=Math.max(map.get(ch)+1,start);
            }
            result=Math.max(result,i-start+1);
            map.put(ch,i);
        }
        return result;
    }
}
