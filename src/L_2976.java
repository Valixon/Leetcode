import java.util.Arrays;

public class L_2976 {

    public static void main(String[] args) {
        System.out.println(minimumCost("aaadbdcdac", "cdbabaddba", new char[]{'a', 'c', 'b', 'd', 'b', 'a', 'c' }, new char[]{'c', 'a', 'd', 'b', 'c', 'b', 'd' }, new int[]{7, 2, 1, 3, 6, 1, 7}));
        System.out.println(minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd' }, new char[]{'b', 'c', 'b', 'e', 'b', 'e' }, new int[]{2, 5, 5, 1, 2, 20}));
        System.out.println(minimumCost("aaaa", "bbbb", new char[]{'a', 'c' }, new char[]{'c', 'b' }, new int[]{1, 2}));
        System.out.println(minimumCost("abcd", "abce", new char[]{'z' }, new char[]{'e' }, new int[]{10000}));
    }

    private static long[][] go;

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long res = 0;
        go = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(go[i], Integer.MAX_VALUE);
            go[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            go[original[i] - 97][changed[i] - 97] = Math.min(go[original[i] - 97][changed[i] - 97], cost[i]);
        }
        yulTanla();

        byte[] a = source.getBytes();
        byte[] b = target.getBytes();
        for (int i = 0; i < a.length; i++) {
            if (go[a[i] - 97][b[i] - 97] == Integer.MAX_VALUE) {
                return -1;
            }
            res += go[a[i] - 97][b[i] - 97];
        }
        return res;
    }

    private static void yulTanla() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (go[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (go[k][j] < Integer.MAX_VALUE) {
                            go[i][j] = Math.min(go[i][j], go[i][k] + go[k][j]);
                        }
                    }
                }
            }
        }
    }
}