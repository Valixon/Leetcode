public class L_1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4/)/+)++1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("2-(2+9)/4-4"));
    }


    public static int maxDepth(String s) {
        for (int i = 0; i <= 9; i++) {
            s = s.replaceAll("" + i, "");
        }
        s = s.replace("+", "");
        s = s.replaceAll("-", "");
        s = s.replace("*", "");
        s = s.replaceAll("/", "");
        System.out.println(s);
        int res = 0;
        while (!s.isEmpty()) {
            s = s.replace("()", "");
            res++;
        }
        return res;
    }
}
