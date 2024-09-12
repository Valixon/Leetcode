public class L_2125 {

    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(numberOfBeams(new String[]{"000", "111", "000"}));
    }


    public static int numberOfBeams(String[] bank) {
        int a = 0;
        int birinchi = 0;
        int sum = 0;
        for (String s : bank) {
            a = 0;
            for (char j : s.toCharArray()) {
                a += (j - 48);
            }
            if (a != 0) {
                sum += birinchi * a;
                birinchi = a;

            }
        }
        return sum;
    }
}