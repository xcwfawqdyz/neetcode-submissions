class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();

        while(n!=1){
            int sum=0;
            while(n!=0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            n=sum;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }
}
