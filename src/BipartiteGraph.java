import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0=uncolored, 1=red, -1=blue

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nei : graph[node]) {
                    if (color[nei] == 0) {
                        color[nei] = -color[node];
                        q.add(nei);
                    } else if (color[nei] == color[node]) {
                        return false; // same color → not bipartite
                    }
                }
            }
        }
        return true;
    }
}
