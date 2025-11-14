import java.util.ArrayList;
import java.util.List;

public class DiagonalTraversal {

    public List<Integer> findDiagonalOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return res;
        }

     int row =0,col=0;
     int N = matrix.length; int M = matrix[0].length;
     boolean upwards = true;
     while(row<N && col<M){
         res.add(matrix[row][col]);
         int newRow = upwards ? row-1: row+1;
         int newCol = upwards ? col+1:col-1;
         if( newRow<0 || newCol<0 || newRow == N || newCol == M){
             if(upwards){
                 row+= (col == M-1)?1:0;
                 col+=(col < M-1) ? 1:0;
             }else{
                 col+=(row == N-1) ? 1:0;
                 row+=(row<N-1)?1:0;
             }
             upwards=!upwards;
         } else{
             row = newRow;
             col = newCol;
         }
     }
     return res;
    }

    public static void main(String[] args) {
        DiagonalTraversal solution = new DiagonalTraversal();
        // Example 1
        int[][] matrix1 = {{1, 5}, {3, 6}};
        System.out.println(solution.findDiagonalOrder(matrix1));

        // Example 2
        int[][] matrix2 = {{1}, {2}, {3}};
        System.out.println(solution.findDiagonalOrder(matrix2));

        // Example 3
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(solution.findDiagonalOrder(matrix3));
    }
}
