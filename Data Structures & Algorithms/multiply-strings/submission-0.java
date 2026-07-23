class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
       int n1=num1.length(),n2=num2.length(); 
       int[] result=new int[n1+n2];
       for(int i=n1-1;i>=0;i--){
            int temp1=num1.charAt(i)-'0';
            for(int j=n2-1;j>=0;j--){
                int temp2=num2.charAt(j)-'0';
                result[i+j+1]+= temp1*temp2;
            }
       }
       int carry=0;
       for(int i=n1+n2-1;i>=0;i--){
         int sum=carry+result[i];
         carry=sum/10;
         result[i]=sum%10;
       }

       int start=0;
       while(result[start]==0){
        start++;
       }
       StringBuilder sb=new StringBuilder();
       for(;start<n1+n2;start++){
        sb.append(result[start]);
       }
       return sb.toString();
    }
}
