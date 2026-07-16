/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> que=new PriorityQueue<>((a,b)->a.end-b.end);
        intervals.sort((a,b)->a.start-b.start);
        for(Interval interval: intervals){
            if(que.isEmpty() || que.peek().end>interval.start ){
                que.offer(interval);
            }else{
                que.poll();
                que.offer(interval);
            }
        }
        return que.size();
    }
}
