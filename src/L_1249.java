import java.util.LinkedList;

public class L_1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }


    public static String minRemoveToMakeValid(String s) {
        int n = s.length();
        byte[] a = new byte[n];
        s.getBytes(0, n, a, 0);
        LinkedList<Integer> joy = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                joy.add(i);
                a[i] = '*';
            } else if (a[i] == ')') {
                if (!joy.isEmpty()) {
                    a[joy.removeLast()] = '(';
                } else {
                    a[i] = '*';
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (byte i : a) {
            if (i != '*') {
                res.append((char) i);
            }
        }
        return res.toString();
    }
}
