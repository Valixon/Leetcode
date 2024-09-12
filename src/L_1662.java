import java.util.Random;

public class L_1662 {
    public static int daraja;

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Random s = new Random();
        return s.nextInt(10) % 2 == 0;
    }
}