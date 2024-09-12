public class L_1716 {

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        for (int i = 1; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (12*i+j == 118){
                    System.out.println(i+" "+j);
                }
            }
        }
        return 1;
    }
}