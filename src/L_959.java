public class L_959 {


    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(regionsBySlashes(new String[]{"/\\", "\\/"}));
    }

    private static boolean[][] katta;

    public static int regionsBySlashes(String[] grid) {
        int res = 0;
        int n = grid.length;
        katta = new boolean[n * 3 + 2][n * 3 + 2];
        for (int i = 0; i < n * 3 + 2; i++) {
            katta[0][i] = true;
            katta[i][0] = true;
            katta[n * 3 + 1][i] = true;
            katta[i][n * 3 + 1] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char q = grid[i].charAt(j);
                switch (q) {
                    case '\\' -> {
                        katta[i * 3 + 1][j * 3 + 1] = true;
                        katta[i * 3 + 2][j * 3 + 2] = true;
                        katta[i * 3 + 3][j * 3 + 3] = true;
                    }
                    case '/' -> {
                        katta[i * 3 + 3][j * 3 + 1] = true;
                        katta[i * 3 + 2][j * 3 + 2] = true;
                        katta[i * 3 + 1][j * 3 + 3] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= n * 3; i++) {
            for (int j = 1; j <= n * 3; j++) {
                if (!katta[i][j]) {
                    res++;
                    tuldir(i, j);
                }
            }
        }
        return res;
    }

    private static void tuldir(int i, int j) {
        if (katta[i][j]) return;
        katta[i][j] = true;
        tuldir(i, j + 1);
        tuldir(i + 1, j);
        tuldir(i - 1, j);
        tuldir(i, j - 1);
    }
}