import java.util.Arrays;

public class L_2429 {
    public static void main(String[] args) {
        System.out.println(minimizeXor(5, 23));
        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));
    }

    public static int minimizeXor(int num1, int num2) {
        System.out.println(Integer.toBinaryString(num1));
        System.out.println(Integer.toBinaryString(num2));
        int count = Integer.bitCount(num2);
        int count2 = Integer.bitCount(num1);
        if (count2 == count) return num1;
        char[] a = Integer.toBinaryString(num1).toCharArray();
        char[] b = new char[a.length];
        Arrays.fill(b, '0');
        if (a.length <= count) {
            return (1 << count) - 1;
        }
        if (count >= count2) {
            count -= count2;
            b = a;
        } else {
            for (int i = 0; i < a.length && count > 0; i++) {
                if (a[i] == '1') {
                    b[i] = '1';
                    count--;
                }
            }
        }
        for (int i = a.length - 1; i >= 0 && count > 0; i--) {
            if (a[i] == '0') {
                b[i] = '1';
                count--;
            }
        }
        int result = 0;
        for (char c : b) {
            result = (result << 1) | (c - '0');
        }
        return result;
    }
}
