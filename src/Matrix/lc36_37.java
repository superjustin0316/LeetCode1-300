package Matrix;

import java.util.HashSet;

public class lc36_37 {

    /**
     * rowIndex = 3 * (i / 3)
     * colIndex = 3 * (i % 3)
     *
     *           0 1 2 3 4 5 6 7 8
     *
     * rowIndex  0 0 0 3 3 3 6 6 6
     * colIndex  0 3 6 0 3 6 0 3 6
     *
     * j / 3     0 0 0 1 1 1 2 2 2
     * j % 3     0 1 2 0 1 2 0 1 2
     *
     *
     * O(n^2) O(n)
     */
    public boolean lc36_1(char[][] board){
        for (int i = 0; i <board.length; i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0 ; i <board[0].length; j++){
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !rows.add(board[j][i])) return false;

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                //检测9宫格
                if (board[rowIndex + j/3][colIndex + j%3] != '.' && !cube.add(board[rowIndex + j/3][colIndex + j%3]))
                        return false;
            }
        }
        return true;

    }

    public boolean lc36_2(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] =='.') continue;
                if (!valid(board,i,j)) return false;
            }
        }
        return true;
    }

    /**
     *  row = (i /3) *3; row <(i/3 + 1) *3
     *        (i/3)*3  (i/3+1)*3
     *  i=0-2    0         3
     *  i=3-5    3         6
     *  i=6-8    6         9
     */
    public boolean valid(char[][] board, int i, int j){
        //判断某一点的横向纵向是否有相同值
        //横向
        for (int row = 0; row < board.length; row++){
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        //纵向
        for (int col = 0; col < board[0].length; col++){
            if (col == j ) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        //判断9宫格
        for (int row = (i/3)*3; row <(i/3+1); row++){
            for (int col = (j/3)*3; col <(j/3+1);col++){
                if (row ==i && col == j) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return  true;
    }



    public void lc37(char[][] board){
        if (board ==null|| board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j <board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char c ='1'; c <= '9'; c++){
                        if (isValid(board,i,j,c)){
                            board[i][j] =c;
                            //1.下一步 可以 return true
                            if (solve(board)) return true; //DFS!! 进行下一步的操作
                            //2. 下一步 不可以 复原当前环境
                            else board[i][j] ='.';
                        }
                    }
                    return false;
                }
            }
        }
        return  true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i <9; i++){
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c){
                return false;
            }
        }
        return true;
    }
}
