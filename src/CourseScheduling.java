import java.util.*;

public class CourseScheduling {
    public boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> sortedList = new ArrayList<>();
        for(int i=0;i<tasks;i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            inDegree.put(child,inDegree.get(child)+1);
            graph.get(parent).add(child);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> map: inDegree.entrySet()){
            if(map.getValue() == 0){
                queue.add(map.getKey());
            }
        }
        while(!queue.isEmpty()){
            int source = queue.poll();
            sortedList.add(source);
            for(int child : graph.get(source)){
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child) == 0){
                    queue.add(child);
                }
            }
        }
        return sortedList.size() ==  tasks;
    }

    public static void main(String[] args) {
        CourseScheduling sol = new CourseScheduling();
        boolean result = sol.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 },
                new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 },
                new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);

        result = sol.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = sol.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
