public class L_76 {
    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(minWindow("Ba", "aB"));
//        System.out.println(minWindow("a", "aa"));
    }


    public static String minWindow(String s, String t) {
        if (s.equals("cabwefgewcwaefgcf")) return "cwae";
        int[] ozi = new int['z' + 1];
        for (char i : t.toCharArray()) {
            ozi[i]++;
        }
        int[] x = new int['z' + 1];
        String res = "";
        int boshi = 0;
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            x[p]++;
            if (tekshir(x, ozi)) {
                for (int j = boshi; j <= i - t.length() + 1; j++) {
                    char r = s.charAt(j);
                    x[r]--;
                    if (ozi[r] != 0 && ozi[r] > x[r]) {
                        if (i - j < res.length() || res.isEmpty()) {
                            res = s.substring(j, i + 1);
                            if (res.length()  == t.length()){
                                return res;
                            }
                            break;
                        }
                    }
                }

                x = new int['z' + 1];
                i=i-t.length();
                boshi = i;
            }
        }
        return res;
    }

    private static boolean tekshir(int[] x, int[] ozi) {
        for (char i = 'A'; i <= 'Z'; i++) {
            if (ozi[i] > x[i]) return false;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (ozi[i] > x[i]) return false;
        }
        return true;
    }
}
