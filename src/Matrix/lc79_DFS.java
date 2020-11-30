package Matrix;

public class lc79_DFS {

    public boolean lc79(char[][] board, String word){
        for (int i = 0; i< board.length; i++){
            for (int j = 0 ; j <board[0].length;j++){
                if (exist(board, i, j, word, 0)){
                    return  true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int start){
        if (start >= word.length()) return true;//说明之前的return 都为true
        if ( i < 0 || i >= board.length || j <0 || j >= board[0].length) return false;


        if (board[i][j] == word.charAt(start++)){
            char c = board[i][j];
            board[i][j] = '#';//表示这个字符已经用过
            boolean res = exist(board,i+1,j,word,start)||
                    exist(board,i-1,j,word,start)||
                    exist(board,i,j-1,word,start)||
                    exist(board,i,j+1,word,start);

            board[i][j] = c;
            return res;
        }
        return false;
    }

}
