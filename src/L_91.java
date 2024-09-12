import java.util.HashMap;
import java.util.Map;

public class L_91 {
    private static Map<String, Integer> soni = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(numDecodings("110"));
//        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }


    public static int numDecodings(String s) {
        char[] a = ("3" + s + "3").toCharArray();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == '0' && a[i - 1] != '1' && a[i - 1] != '2') return 0;
        }
        return rekursiya(s);
    }

    private static int rekursiya(String s) {
        if (s.length() != 0 && s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() < 2) {
            return 1;
        }

        if (s.charAt(1) == '0') {
            s = s.substring(2);
            if (soni.containsKey(s)) {
                return soni.get(s);
            }
            int son = rekursiya(s);
            soni.put(s, son);
            return son;
        } else {
            int x = Integer.parseInt(s.substring(0, 2));
            if (x > 26) {
                s = s.substring(1);
                if (soni.containsKey(s)) {
                    return soni.get(s);
                }
                int son = rekursiya(s);
                soni.put(s, son);
                return son;
            } else {
                int son = 0;
                s = s.substring(1);
                if (soni.containsKey(s)) {
                    son = soni.get(s);
                }
                son = rekursiya(s);
                soni.put(s, son);

                s = s.substring(1);
                if (soni.containsKey(s)) {
                    return soni.get(s) + son;
                }
                int son2 = rekursiya(s);
                soni.put(s, son2);
                return son + son2;
            }
        }
    }
}