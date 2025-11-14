import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Interval>  result = new ArrayList<Interval>();
            PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
            schedule.forEach(e -> pq.addAll(e));
            Interval temp = pq.poll();
            while(!pq.isEmpty()){
                Interval current = pq.poll();
                if(temp.end<current.start){
                    result.add(new Interval(temp.end,current.start));
                    temp = current;
                }else{
                    temp.end = Math.max(temp.end,current.end);
                }
            }
            return result;
        }
    }

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};