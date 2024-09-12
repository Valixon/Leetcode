import java.util.Scanner;

public class L_1615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] a = new int[p][2];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(maximalNetworkRank(n, a));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        byte a[] = new byte[n];
        byte q[][] = new byte[n][n];
        int p = roads.length;
        for (int i = 0; i < p; i++) {
            a[roads[i][0]]++;
            a[roads[i][1]]++;
            q[roads[i][0]][roads[i][1]] = 1;
            q[roads[i][1]][roads[i][0]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, a[i] + a[j] - q[i][j]);
            }
        }
        return max;
    }

    public static int getConnect(int index1, int index2, int[][] roads) {
        int p = roads.length;
        for (int i = 0; i < p; i++) {
            if ((roads[i][0] == index2 && roads[i][1] == index1) || (roads[i][0] == index1 && roads[i][1] == index2)) {
                return 1;
            }
        }
        return 0;
    }
}
// 8 3    1 3 -1 -3 5 3 6 7