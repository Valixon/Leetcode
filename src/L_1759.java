public class L_1759 {
    public static void main(String[] args) {
//        System.out.println(eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
//        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(countHomogenous("xy"));
        System.out.println(countHomogenous("zzzzz"));
    }

    public static int countHomogenous(String s) {
        char hozir = s.charAt(0);
        int count = 1;
        long summa = 0;
        s = s.substring(1);
        for (char i : s.toCharArray()) {
            if (i == hozir) {
                count++;
            } else {
                summa += (((1 + (long) count) * (long) count) / 2);
                count = 1;
                hozir = i;
            }
        }
        summa += (((1 + (long) count) * (long) count) / 2);
        return (int) (summa % 1000000007);
    }

}
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]