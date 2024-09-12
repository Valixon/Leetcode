public class L_1903 {

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }

    public static String largestOddNumber(String num) {
        int max = -1;
        max = Math.max(num.lastIndexOf("1"), max);
        max = Math.max(num.lastIndexOf("3"), max);
        max = Math.max(num.lastIndexOf("5"), max);
        max = Math.max(num.lastIndexOf("7"), max);
        max = Math.max(num.lastIndexOf("9"), max);
        return num.substring(0, max + 1);
    }
}