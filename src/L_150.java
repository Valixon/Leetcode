public class L_150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        int x;
        int last1 = 1;
        int last2 = 1;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    x = last1 + last2;
                    last1 = last2;
                    last2 = x;
                }
                case "-" -> {
                    x = last2 - last1;
                    last1 = last2;
                    last2 = x;
                }
                case "*" -> {
                    x = last1 * last2;
                    last1 = last2;
                    last2 = x;
                }
                case "/" -> {
                    x = last2 / last1;
                    last1 = last2;
                    last2 = x;
                }
                default -> {
                    last1 = last2;
                    last2 = Integer.parseInt(token);
                }
            }
        }
        return last2;
    }
}
