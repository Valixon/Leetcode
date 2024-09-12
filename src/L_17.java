import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String digits) {
        String[][] a = new String[10][];
        a[2] = new String[]{"a", "b", "c"};
        a[3] = new String[]{"d", "e", "f"};
        a[4] = new String[]{"g", "h", "i"};
        a[5] = new String[]{"j", "k", "l"};
        a[6] = new String[]{"m", "n", "o"};
        a[7] = new String[]{"p", "q", "r", "s"};
        a[8] = new String[]{"t", "u", "v"};
        a[9] = new String[]{"w", "x", "y", "z"};
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return Arrays.asList(a[Integer.parseInt(digits)]);
        }
        if (digits.length() == 2) {
            int x = Integer.parseInt(digits.substring(0, 1));
            int y = Integer.parseInt(digits.substring(1, 2));
            List<String> result = new ArrayList<>();
            for (int i = 0; i < a[x].length; i++) {
                for (int j = 0; j < a[y].length; j++) {
                    result.add(a[x][i] + "" + a[y][j]);
                }
            }
            return result;
        }
        if (digits.length() == 3) {
            int x = Integer.parseInt(digits.substring(0, 1));
            int y = Integer.parseInt(digits.substring(1, 2));
            int z = Integer.parseInt(digits.substring(2, 3));
            List<String> result = new ArrayList<>();
            for (int i = 0; i < a[x].length; i++) {
                for (int j = 0; j < a[y].length; j++) {
                    for (int k = 0; k < a[z].length; k++) {
                        result.add(a[x][i] + "" + a[y][j] + "" + a[z][k]);
                    }
                }
            }
            return result;
        }
        int x = Integer.parseInt(digits.substring(0, 1));
        int y = Integer.parseInt(digits.substring(1, 2));
        int z = Integer.parseInt(digits.substring(2, 3));
        int t = Integer.parseInt(digits.substring(3, 4));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < a[x].length; i++) {
            for (int j = 0; j < a[y].length; j++) {
                for (int k = 0; k < a[z].length; k++) {
                    for (int l = 0; l < a[t].length; l++) {
                        result.add(a[x][i] + "" + a[y][j] + "" + a[z][k] + "" + a[t][l]);
                    }
                }
            }
        }
        return result;
    }
}
