class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size=0;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(minHeap.size()-maxHeap.size()>0){
            minHeap.offer(num);
            int temp=minHeap.poll();
            maxHeap.offer(temp);
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        size++;
    }
    
    public double findMedian() {
        return size%2==0? (minHeap.peek()+maxHeap.peek())/2.0 : minHeap.peek();

    }
}
