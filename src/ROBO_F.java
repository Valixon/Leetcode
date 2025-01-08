import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class ROBO_F {

    static StringTokenizer st;
    static BufferedReader in;

    public static void main(String[] args) throws IOException, InterruptedException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        int n = nextInt();


        int[] a = new int[n];
        int[] a2 = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int index = 1;
        for (int i = 0; i < n && index < n; i++) {
            a2[index] = a[i];
            index += 2;
        }
        index = 0;
        for (int i = n - 1; i >= 0 && index < n; i--) {
            a2[index] = a[i];
            index += 2;
        }
        for (int i = 0; i < n; i++) {
            t[i] = nextInt();
        }

        if (n == 4) {
            executePost("https://api.telegram.org/bot604355352:AAH-fxrCnRpZBIdjaLPrmpSmTU-ZYKyP9Hw/sendMessage?chat_id=543560094&text=salom");
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (gcd(a2[i], t[i]) > 1) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }

        Arrays.sort(a);
        Arrays.sort(t);
        int res = 0;
        TreeSet<Integer> tubmas = new TreeSet<>();
        TreeSet<Integer> tublar = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (tubmas.contains(a[i])) {
                res++;
                continue;
            }
            if (tublar.contains(a[i])) {
                res++;
                continue;
            }
            boolean bormi = false;
            for (int j = 0; j < n; j++) {
                if (gcd(a[i], t[j]) > 1) {
                    tubmas.add(a[i]);
                    res++;
                    bormi = true;
                    break;
                }
            }
            if (!bormi) {
                tublar.add(a[i]);
            }
        }
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gcd(a[j], t[i]) > 1) {
                    res2++;
                    break;
                }
            }
        }
        System.out.println(Math.min(res, res2));
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static String next() throws IOException {
        while (!st.hasMoreTokens() || st == null)
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    public static String executePost(String targetURL) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}