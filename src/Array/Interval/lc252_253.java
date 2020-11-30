package Array.Interval;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc252_253 {

    public class Interval{
        int start;
        int end;
        public Interval() {
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // nlogn    1
    public boolean lc252(Interval[] intervals){//判断区间交集
        Arrays.sort(intervals,(x,y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start){
                return false;
            }
        }
        return true;
    }


    public int lc253(Interval[] intervals){
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < ends.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);//按照start开始时间排序
        Arrays.sort(ends);
        int res = 0;
        int end = 0;

        for (int i = 0; i < ends.length; i++) {
            if (starts[i] < ends[end]){
                res++;//某一场会议结束之前的，有几场会议开始就要几个房间
            }else{
                end++;
            }
        }
        return res;
    }

    public int lc253solution2(Interval[] intervals){
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a,b)->a.end-b.end);
        heap.offer(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            Interval time = heap.poll();
            if (intervals[i].start >= time.end){//区间不重叠
                time.end = intervals[i].end;//可以合并区间
            } else {//区间重叠
                heap.offer(intervals[i]);//重新开辟一个时间段
            }
            heap.offer(time);//更新
        }
        return heap.size();
    }
}
