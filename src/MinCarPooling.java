import java.util.TreeMap;

public class MinCarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        int passengers,start,end=0;
        int usedCapacity=0;
        for(int[] trip:trips){
            passengers = trip[0];
            start = trip[1];
            end = trip[2];
            diff[start]+=passengers;
            diff[end]-=passengers;
        }
        for(int i=0;i<1001;i++){
            usedCapacity+=diff[i];
            if(usedCapacity>capacity){
                return false;
            }
        }
        return true;
    }
//    Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//    Output: false
        public boolean carPoolingWithMap(int[][] trips, int capacity) {
         //   {1: +2, 3: +3, 5: -2, 7: -3} treeMap for sortedKey

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int[] trip : trips) {
                int p = trip[0], start = trip[1], end = trip[2];

                map.put(start, map.getOrDefault(start, 0) + p);
                map.put(end,   map.getOrDefault(end,   0) - p);
            }

            int used = 0;

            for (int delta : map.values()) {
                used += delta;
                if (used > capacity) return false;
            }

            return true;
        }


}
