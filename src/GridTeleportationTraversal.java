import java.util.*;

public class GridTeleportationTraversal {
    public int minMoves(String[] matrix) {
        int m = matrix.length, n = matrix[0].length();

        Map<Character, List<int[]>> portalMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = matrix[i].charAt(j);
                if (ch >= 'A' && ch <= 'Z') {
                    portalMap.computeIfAbsent(ch, k -> new ArrayList<>())
                            .add(new int[]{i, j});
                }
            }
        }

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        boolean[] usedPortal = new boolean[26];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) {
                return dist[r][c];
            }

            // normal moves (cost 1)
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                        matrix[nr].charAt(nc) != '#') {

                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        dq.offerLast(new int[]{nr, nc});
                    }
                }
            }

            // teleport moves (cost 0)
            char ch = matrix[r].charAt(c);
            if (ch >= 'A' && ch <= 'Z' && !usedPortal[ch - 'A']) {
                usedPortal[ch - 'A'] = true;
                for (int[] pos : portalMap.get(ch)) {
                    int nr = pos[0], nc = pos[1];
                    if (dist[nr][nc] > dist[r][c]) {
                        dist[nr][nc] = dist[r][c];
                        dq.offerFirst(new int[]{nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}
