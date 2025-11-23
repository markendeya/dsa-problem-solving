import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int countIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int totalIslands = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    totalIslands++;
                    dfs(i,j,grid,row,col);
                }
            }
        }
        return totalIslands;
    }
    private void dfs(int row,int col,int[][] grid,int m,int n){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col] == 0){
            return;
        }
        grid[row][col] = 0;
        dfs(row-1,col,grid,m,n);
        dfs(row+1,col,grid,m,n);
        dfs(row,col-1,grid,m,n);
        dfs(row,col+1,grid,m,n);
    }
    private static void visitIslandBFS(int[][] matrix, int x, int y) {
        Queue<int[]> neighbors = new LinkedList<>();
        neighbors.add(new int[] { x, y });
        while (!neighbors.isEmpty()) {
            int row = neighbors.peek()[0];
            int col = neighbors.peek()[1];
            neighbors.remove();

            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0)
                continue;
            matrix[row][col] = 0;

            // insert all neighboring cells to the queue for BFS
            neighbors.add(new int[] { row + 1, col }); // lower cell
            neighbors.add(new int[] { row - 1, col }); // upper cell
            neighbors.add(new int[] { row, col + 1 }); // right cell
            neighbors.add(new int[] { row, col - 1 }); // left cell
        }
    }
    int []dx ={1,-1,0,0};
    int [] dy ={0,0,-1,1};
    private void dfs(int row,int col, char[][] grid,int m,int n,int[]dx,int[]dy){

        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        for(int i=0;i<4;i++){
            dfs(row+dx[i],col+dy[i],grid,m,n,dx,dy);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        System.out.println(sol.countIslands(
                new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }));

        System.out.println(sol.countIslands(
                new int[][] {
                        { 0, 1, 1, 1, 0 },
                        { 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));
    }
}
