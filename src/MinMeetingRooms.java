import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int m = intervals.length;
        int[] startTime = new int[m];
        int[] endTime = new int[m];
        for (int i = 0; i < m; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
 /*       int roomsRequired=0, endPtr=0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] < endTime[endPtr]) {
                roomsRequired++;       // need new room
            } else {
                endPtr++;      // free one room
            }
        }
        return roomsRequired; */
        int roomsRequired=0,minRoomsRequired = 0;
        int i = 0,j = 0;
        while (i < m && j < m) {
            if (startTime[i] < endTime[j]) {
                roomsRequired++;
                i++;
            } else {
                j++;
                roomsRequired--;
            }
            minRoomsRequired = Math.max(minRoomsRequired, roomsRequired);
        }
        return minRoomsRequired;
    }
    public int minMeetingRoomsPQ(int[][] intervals) {
                if (intervals == null || intervals.length == 0)
                    return 0;
                int minRooms =0;
                Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
                for(int[] interval: intervals){
                    int startTime = interval[0];
                    // int endTime = pq.peek()[1];
                    while(!pq.isEmpty() && startTime>= pq.peek()[1]){
                        pq.poll();
                    }
                    pq.add(interval);
                    minRooms = Math.max(minRooms,pq.size());
                }
                return minRooms;
    }
}