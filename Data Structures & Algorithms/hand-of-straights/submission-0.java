class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Arrays.sort(hand);
        Map<Integer,Integer> map=new HashMap<>();
        for(int h:hand){
            map.put(h,map.getOrDefault(h,0)+1);
        }
        for(int h:hand){
            if(map.containsKey(h)){
                for(int j=0;j<groupSize;j++){
                    int num=h+j;
                    if(!map.containsKey(num)) return false;
                    map.put(num,map.get(num)-1);
                    if(map.get(num)==0){
                        map.remove(num);
                    }
                }
            }
        }
        return true;
    }
}
