import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int [] visited = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(graph,visited,i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int [][] graph, int[] visited, int node){
        if(visited[node] == -1){
            return true;
        }
        if (visited[node] == 1) {
            return false;
        }
        visited[node] = 1;
        for(int nextNode : graph[node]){
            if(!dfs(graph,visited,nextNode)){
                return false;
            }
        }
        visited[node] = -1;
        return true;
    }

    public static void main(String[] args) {
        EventualSafeStates sol = new EventualSafeStates();
        System.out.println(sol.eventualSafeNodes(new int[][]{{1,2},{2,3},{2},{},{5},{6},{}}));
        System.out.println(sol.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{},{},{4}}));
        System.out.println(sol.eventualSafeNodes(new int[][]{{1,2,3},{2,3},{3},{},{0,1,2}}));
    }
}
