class Solution {
    public double myPow(double x, int n) {
        double temp=helper(x,Math.abs(n));
        return n>0?temp:1/temp;
    }
    private double helper(double x, int n){
        if(n==0) return 1;
        if(n==1) return x;
        double temp=helper(x, n/2);
        temp=temp*temp;
        return n%2==0?temp:temp*x;
    }
}
