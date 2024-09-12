import java.util.ArrayList;
import java.util.List;

public class L_212 {
    private static int[][] joyi = new int[10][2];

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
    }


    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            joyi = new int[word.length()][2];
            String x = word;
            if (word.length() > 1 && word.charAt(0) == word.charAt(1)) {
                x = String.valueOf(new StringBuilder(word).reverse());
            }
            if (salom(board, x)) {
                res.add(word);
                revertBoard(board, x);
            }
        }
        return res;
    }

    private static void revertBoard(char[][] board, String word) {
        for (int i = 0; i < word.length(); i++) {
            board[joyi[i][0]][joyi[i][1]] = word.charAt(i);
        }
    }

    public static boolean salom(char[][] board, String word) {
        char a = word.charAt(0);
        String x = word.substring(1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == a) {
                    board[i][j] = ' ';
                    joyi[0][0] = i;
                    joyi[0][1] = j;
                    if (hisobla(i, j, board, x, 1)) return true;
                    board[i][j] = a;
                }
            }
        }
        return false;
    }

    private static boolean hisobla(int i, int j, char[][] board, String word, int index) {
        if (word.isEmpty()) return true;
        char finder = word.charAt(0);
        String x = word.substring(1);
        if (j + 1 < board[0].length && board[i][j + 1] == finder) {
            board[i][j + 1] = ' ';
            joyi[index][0] = i;
            joyi[index][1] = j + 1;
            if (hisobla(i, j + 1, board, x, index + 1)) return true;
            board[i][j + 1] = finder;
        }
        if (j - 1 >= 0 && board[i][j - 1] == finder) {
            board[i][j - 1] = ' ';
            joyi[index][0] = i;
            joyi[index][1] = j - 1;
            if (hisobla(i, j - 1, board, x, index + 1)) return true;
            board[i][j - 1] = finder;
        }
        if (i + 1 < board.length && board[i + 1][j] == finder) {
            board[i + 1][j] = ' ';
            joyi[index][0] = i + 1;
            joyi[index][1] = j;
            if (hisobla(i + 1, j, board, x, index + 1)) return true;
            board[i + 1][j] = finder;
        }
        if (i - 1 >= 0 && board[i - 1][j] == finder) {
            board[i - 1][j] = ' ';
            joyi[index][0] = i - 1;
            joyi[index][1] = j;
            if (hisobla(i - 1, j, board, x, index + 1)) return true;
            board[i - 1][j] = finder;
        }
        return false;
    }
}
