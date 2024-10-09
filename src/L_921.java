public class L_921 {
    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }


    public static int minSwaps(String s) {
        byte[] o = new byte[s.length() + 1];
        o[0] = (byte) '0';
        byte[] a = s.getBytes();
        int index = 0;
        for (var ch : a) {
            if (ch == ')' && o[index] == '(') {
                index--;
            } else {
                o[++index] = ch;
            }
        }
        return index;
    }
}
