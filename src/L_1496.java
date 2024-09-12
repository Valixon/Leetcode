
public class L_1496 {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossing("NESSWWNNWNEES"));
    }


    public static boolean isPathCrossing(String path) {
        int[][] a = new int[101][101];
        int x = 50;
        int y = 50;
        a[x][y] = 1;
        for (char i : path.toCharArray()) {
            switch (i) {
                case 'N' -> x++;
                case 'S' -> x--;
                case 'E' -> y++;
                case 'W' -> y--;
            }
            a[x][y]++;
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (a[i][j] > 1) return true;
            }
        }
        return false;
    }
}