import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    char num = board[i][j];
                    if(!seen.add(num + "found in row " + i)||
                            !seen.add(num + "found in col " + j)||
                            !seen.add(num + "found in box "+ i/3 + "-" + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
