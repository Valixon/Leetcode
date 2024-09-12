public class L_592 {
    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition("1/3-1/2"));
    }


    public static String fractionAddition(String expression) {
        long surati = 0;
        long maxraj = 1;
        if (expression.charAt(0) != '-') {
            expression = "+" + expression;
        }
        expression = expression + "+-";
        while (expression.length() > 2) {
            String suratSting = expression.substring(0, expression.indexOf('/'));
            expression = expression.substring(suratSting.length() + 1);
            String maxrajSting = expression.substring(0, Math.min(expression.indexOf('+'), expression.indexOf('-')));
            expression = expression.substring(maxrajSting.length());
            long suratInteger = Long.parseLong(suratSting);
            long maxrajInteger = Long.parseLong(maxrajSting);
            long ekub = gcd(maxrajInteger, maxraj);
            long o1 = (maxrajInteger * maxraj) / ekub;
            surati = surati * (o1 / maxraj);
            suratInteger = suratInteger * (o1 / maxrajInteger);
            surati = surati + suratInteger;
            maxraj = o1;

        }
        long ekub = gcd(Math.abs(surati), maxraj);
        surati = surati / ekub;
        maxraj = maxraj / ekub;
        return surati + "/" + maxraj;
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, Math.abs(a - b));
    }
}