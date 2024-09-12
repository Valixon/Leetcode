import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class R_0797 {
    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = nextInt();
        String s = next();
        char[] a = s.toCharArray();
        Map<String, List<Integer>> b = new TreeMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            b.put(i + "", new ArrayList<>());
        }
        String s2 = "";
        Map<String, Integer> res = new HashMap<>();
        res.put("", 0);
        int count = 0;

        int current = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == '-') {
                current--;
                s2 = s2.substring(0, s2.length() - 1);
                List<Integer> index = b.get(a[current] + "");
                index.remove(index.size() - 1);
                b.put(a[current] + "", index);
                count = res.get(s2);
                System.out.print(count + " ");
            } else {
                count++;
                current++;
                List<Integer> index = b.get(a[i] + "");
                index.add(i);
                b.put(a[i] + "", index);
                s2 = s2 + a[i];
                count = count + getCountPalindrome(s2, index);
                res.put(s2, count);
                System.out.print(count + " ");
            }

        }

    }

    private static int getCountPalindrome(String s, List<Integer> index) {
        int count = 0;
        int last = index.get(index.size() - 1);
        for (int i : index) {
            if (i == last) return count;
            String s2 = s.substring(i, last + 1);
            StringBuilder s1 = new StringBuilder(s2);
            s1.reverse();
            if (s1.toString().equals(s2)) {
                count++;
            }
        }
        return count;
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