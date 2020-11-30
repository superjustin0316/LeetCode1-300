package Array.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class lc56_57 {

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


    /**
     * 扫描线算法 -> 将重叠的区间合并掉
     *   n n
     */
    public List<Interval> lc56(List<Interval> intervals){
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals,(a,b) -> a.start-b.start);//??collection与array的区别
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval:intervals){
//            if(interval.start <= end){   //区间重叠(后者.start <= 前者.end)
//                end = Math.max(end,interval.end);
//            } else{
//                res.add(new Interval(start,end));//设置新的start，end
//                start = interval.start;
//                end = interval.end;
//            }
            if(interval.start > end){ //常规情况：区间不重叠
                res.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            } else {//区间重叠
                end = Math.max(end, interval.end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    //合并区间
    public List<Interval> lc57(List<Interval> intervals, Interval newInteral){
        if (newInteral == null) return intervals;
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInteral.start){
            res.add(intervals.get(i++));//newInteral的头部与区间不重叠
        }
        //以下：end >= start -> newInteral的头部重叠i++;

        while (i<intervals.size() && intervals.get(i).start <= newInteral.end){//尾部重叠
            newInteral.start = Math.min(newInteral.start, intervals.get(i).start );
            newInteral.end = Math.max(newInteral.end, intervals.get(i).end);
            i++;
        }
        res.add(newInteral);
        while (i < intervals.size()){
            res.add(intervals.get(i));
            i++;//?
        }
        return res;
    }
}
