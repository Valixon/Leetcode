public class L_3280 {
    public static void main(String[] args) {
        System.out.println(convertDateToBinary("2080-02-29"));
        System.out.println(convertDateToBinary("1900-01-01"));
    }

    public static String convertDateToBinary(String date) {
        return Integer.toBinaryString(Integer.parseInt(date.substring(0, 4))) + "-" + Integer.toBinaryString(Integer.parseInt(date.substring(5, 7))) + "-" + Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)));
    }

}