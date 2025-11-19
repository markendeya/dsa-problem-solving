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
