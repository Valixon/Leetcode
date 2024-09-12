public class L_860 {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));

    }

    public static boolean lemonadeChange(int[] bills) {
        short besh = 0;
        short on = 0;
        for (int num : bills) {
            switch (num) {
                case 5:
                    besh++;
                    break;
                case 10:
                    besh--;
                    on++;
                    break;
                default:
                    if (on > 0) {
                        on--;
                        besh--;
                    } else {
                        besh -= 3;
                    }
                    break;
            }
            if (besh < 0 || on < 0) return false;
        }
        return true;
    }
}