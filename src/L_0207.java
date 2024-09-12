import java.io.PrintWriter;
import java.util.Scanner;

public class L_0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] a = new int[x][2];
        for (int i = 0; i < x; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        pw.print(canFinish(n, a));
        pw.close();
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] a = new int[numCourses];
        int[] b = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            a[prerequisites[i][0]]++;
            if (prerequisites[i][1] == prerequisites[i][0] || (a[prerequisites[i][1]] != 0 && b[prerequisites[i][0]] != 0)) {
                return false;
            }
            b[prerequisites[i][1]]++;
        }
        return true;
    }
}
