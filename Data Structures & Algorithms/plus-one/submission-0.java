class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list=Arrays.stream(digits).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int carry=1;
        for(int i=0;i<list.size();i++){
            int sum=list.get(i)+carry;
            list.set(i,sum%10);
            carry=sum/10;
        }
        if(carry==1){
            list.add(1);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }
    
}
