public class L_3170 {

    public static void main(String[] args) {
        System.out.println(clearStars("aaba*"));
        System.out.println(clearStars("abc"));
    }


    public static String clearStars(String s) {
        while (s.contains("*")) {
            int index = s.indexOf('*');
            String s1 = s.substring(0, index);
            for (char i = 'a'; i < 'z'; i++) {
                int p = s1.lastIndexOf(i);
                if (p > -1) {
                    s1 = s1.substring(0, p) + s1.substring(p + 1);
                    break;
                }
            }
            s = s1 + s.substring(index + 1);
        }
        return s;
    }
}