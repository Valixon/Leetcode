import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class R_0439 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        System.out.println("?");
        System.out.println("4");
        System.out.println("1 2 3 4");
        System.out.println("4");
        System.out.println("5 6 7 8");
        int n = nextInt();
        if (n == 0) {
            System.out.println("?");
            System.out.println("3");
            System.out.println("1 2 3");
            System.out.println("3");
            System.out.println("9 10 11");
            n = nextInt();
            if (n == 0) {
                System.out.println("?");
                System.out.println("1");
                System.out.println("1");
                System.out.println("1");
                System.out.println("12");
                n = nextInt();
                if (n == 0) {
                    System.out.println("! 13");
                } else {
                    System.out.println("! 12");
                }
            } else {
                System.out.println("?");
                System.out.println("1");
                System.out.println("9");
                System.out.println("1");
                System.out.println("10");
                int n2 = nextInt();
                if (n2 == 0) {
                    System.out.println("! 11");
                } else {
                    if (n == n2) {
                        System.out.println("! 10");
                    } else {
                        System.out.println("! 9");
                    }
                }
            }
        } else {
            System.out.println("?");
            System.out.println("4");
            System.out.println("9 10 11 4");
            System.out.println("4");
            System.out.println("1 2 3 8");
            int n2 = nextInt();
            if (n2 == 0) {
                System.out.println("?");
                System.out.println("1");
                System.out.println("5");
                System.out.println("1");
                System.out.println("6");
                n2 = nextInt();
                if (n2 == 0) {
                    System.out.println("! 7");
                } else {
                    if (n == n2) {
                        System.out.println("! 6");
                    } else {
                        System.out.println("! 5");
                    }
                }
            } else {
                if (n == n2) {
                    System.out.println("?");
                    System.out.println("1");
                    System.out.println("1");
                    System.out.println("1");
                    System.out.println("4");
                    int n3 = nextInt();
                    if (n3 == 0) {
                        System.out.println("! 8");
                    } else {
                        System.out.println("! 4");
                    }
                } else {
                    System.out.println("?");
                    System.out.println("1");
                    System.out.println("1");
                    System.out.println("1");
                    System.out.println("2");
                    int n3 = nextInt();
                    if (n3 == 0) {
                        System.out.println("! 3");
                    } else {
                        if (n3 == n) {
                            System.out.println("! 1");
                        } else {
                            System.out.println("! 2");
                        }
                    }
                }
            }
        }

    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
}