import java.util.*;

public class BusRoutes {
    static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key, V value){
            this.key=key;
            this.value=value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
    //routes: [[2, 3, 4], [5, 6, 7, 8], [4, 5, 9, 10], [10, 12]] source: 3 target: 12
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopsBusMap = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int stop : routes[i]){
                stopsBusMap.computeIfAbsent(stop,k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(source,0));
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        while(!queue.isEmpty()){
            Pair<Integer,Integer> current = queue.poll();
            int stop = current.getKey();
            int buses = current.getValue();
            if(stop == target)  return buses;
            for(int bus : stopsBusMap.get(stop)){
                if(!visitedBuses.add(bus)) continue;
                for(int nextStop :routes[bus]){
                   if(nextStop == target) return buses + 1;
                   if(visitedStops.add(nextStop)){
                       queue.add( new Pair<>(nextStop,buses+1));
                   }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        BusRoutes solution = new BusRoutes();
        // Example 1
        int[][] routesA = {{2, 3, 4}, {5, 6, 7, 8}, {4, 5, 9, 10}, {10, 12}};
        System.out.println(solution.numBusesToDestination(routesA, 3, 12)); // Output: 3

        // Example 2
        int[][] routesB = {{1, 2, 3, 4, 5}, {5, 6, 7, 8}, {8, 9, 10, 11}};
        System.out.println(solution.numBusesToDestination(routesB, 1, 11)); // Output: 3

        // Example 3
        int[][] routesC = {{1, 2, 5}, {3, 6, 7}, {7, 9, 10}};
        System.out.println(solution.numBusesToDestination(routesC, 2, 10)); // Output: -1
    }
}
