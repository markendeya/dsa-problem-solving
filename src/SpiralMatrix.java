import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();

            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;

            while (top <= bottom && left <= right) {
               // left to right  [top][left->right]
                for (int col = left; col <= right; col++)
                    ans.add(matrix[top][col]);
                top++;
                 //[top->bottom][right] same col
                for (int row = top; row <= bottom; row++)
                    ans.add(matrix[row][right]);
                right--;
               // [bottom][right->left]
                if (top <= bottom) {
                    for (int col = right; col >= left; col--)
                        ans.add(matrix[bottom][col]);
                    bottom--;
                }
               // [bottom->top][left] same col
                if (left <= right) {
                    for (int row = bottom; row >= top; row--)
                        ans.add(matrix[row][left]);
                    left++;
                }
            }

            return ans;
        }

}
