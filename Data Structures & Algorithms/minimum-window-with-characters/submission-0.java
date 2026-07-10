class Solution {
    public String minWindow(String s, String t) {
        if(s.isEmpty()) return "";
        Map<Character,Integer> countT=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        int[] res=new int[]{-1,-1};
        int len=s.length()+1;

        for(char ch:t.toCharArray()){
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }
        int matches=0;
        int need=countT.size();
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(countT.containsKey(ch) && window.get(ch) ==countT.get(ch) ){
                matches++;
            }
            while(matches==need){
                if(r-l+1<len){
                    len=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char leftChar=s.charAt(l);
                window.put(leftChar,window.get(leftChar)-1);
                if(countT.containsKey(leftChar) && countT.get(leftChar)-1==window.get(leftChar)){
                    matches--;
                }
                l++;
            }
        }
        return len == s.length()+1 ? "":s.substring(res[0],res[1]+1);

    }
}
