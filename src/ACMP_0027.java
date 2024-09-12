import java.io.PrintWriter;
import java.util.Scanner;


public class ACMP_0027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int b=sc.nextInt();
        int [][] a=new int [m+1][n+1];
        for (int i =1; i <=b; i++) {
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            for (int j =y1; j <y2; j++) {
                for (int k =x1; k <x2; k++) {
                    a[j][k]=1;
                }
            }
        }int s=n*m;
        for (int i =0; i<=m; i++) {
            for (int j =0; j <=n; j++) {
                s-=a[i][j];
            }
        }
        pw.print(s);
        pw.close();
    }
}
