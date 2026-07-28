class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list=new ArrayList<>();
        for(int[] trip:triplets){
            if(trip[0]>target[0]||trip[1]>target[1]||trip[2]>target[2]){
                continue;
            }
            list.add(trip);
        }
        boolean[] exist=new boolean[3];
        for(int[] trip:list){
            for(int i=0;i<3;i++){
                if(trip[i]==target[i]){
                    exist[i]=true;
                }
            }
        }
        for(int i=0;i<3;i++){
            if(!exist[i]) return false;
        }
        return true;
    }
}
