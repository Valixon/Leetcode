public class L_1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
//        System.out.println(reverseParentheses("(u(love)i)"));
//        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    public static String reverseParentheses(String s) {
        s = "";
        for (int i = 1; i <= 10; i++) {
            s = s + "a";
        }
        for (int i = 1; i <= 10; i++) {
            s = s + "b";
        }
        return s;
    }
}