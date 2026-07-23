class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=sumOfSquare(n);
        while(slow!=fast){
            fast=sumOfSquare(fast);
            fast = sumOfSquare(fast);
            slow = sumOfSquare(slow);
        }
        return fast==1;
    }
    private int sumOfSquare(int n){
        int output=0;
        while(n!=0){
            int temp=n%10;
            output+=temp*temp;
            n/=10;
        }
        return output;
    }
}
