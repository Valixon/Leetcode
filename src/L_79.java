public class L_79 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }


    public static boolean exist(char[][] board, String word) {
        char a = word.charAt(0);
        String x = word.substring(1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == a) {
                    board[i][j] = ' ';
                    if (hisobla(i, j, board, x)) return true;
                    board[i][j] = a;

                }
            }
        }
        return false;
    }

    private static boolean hisobla(int i, int j, char[][] board, String word) {
        if (word.isEmpty()) return true;
        char finder = word.charAt(0);
        String x = word.substring(1);
        if (j + 1 < board[0].length && board[i][j + 1] == finder) {
            board[i][j + 1] = ' ';
            if (hisobla(i, j + 1, board, x)) return true;
            board[i][j + 1] = finder;
        }
        if (j - 1 >= 0 && board[i][j - 1] == finder) {
            board[i][j - 1] = ' ';
            if (hisobla(i, j - 1, board, x)) return true;
            board[i][j - 1] = finder;
        }
        if (i + 1 < board.length && board[i + 1][j] == finder) {
            board[i + 1][j] = ' ';
            if (hisobla(i + 1, j, board, x)) return true;
            board[i + 1][j] = finder;
        }
        if (i - 1 >= 0 && board[i - 1][j] == finder) {
            board[i - 1][j] = ' ';
            if (hisobla(i - 1, j, board, x)) return true;
            board[i - 1][j] = finder;
        }
        return false;
    }
}
