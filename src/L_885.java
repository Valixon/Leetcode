import java.util.Arrays;

public class L_885 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(1, 4, 0, 0)));
        System.out.println(Arrays.deepToString(spiralMatrixIII(5, 6, 1, 4)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];

        int qadam = 1;
        int index = 0;
        int y = 0;
        while (index < (rows * cols)) {
            // o'nga yur
            for (int i = cStart + y; i <= cStart + qadam; i++) {
                if (i >= 0 && i < cols && rStart < rows && rStart >= 0) {
                    res[index][0] = rStart;
                    res[index][1] = i;
                    index++;
                }
            }
            cStart += qadam;
            // pastga yur
            for (int i = rStart + 1; i <= rStart + qadam; i++) {
                if (i >= 0 && i < rows && cStart < cols && cStart >= 0) {
                    res[index][0] = i;
                    res[index][1] = cStart;
                    index++;
                }
            }
            rStart += qadam;
            qadam++;
            // chapga yur
            for (int i = cStart - 1; i >= cStart - qadam; i--) {
                if (i >= 0 && i < cols && rStart < rows && rStart >= 0) {
                    res[index][0] = rStart;
                    res[index][1] = i;
                    index++;
                }
            }
            cStart -= qadam;
            // yuqori yur
            for (int i = rStart - 1; i >= rStart - qadam; i--) {
                if (i >= 0 && i < rows && cStart < cols && cStart >= 0) {
                    res[index][0] = i;
                    res[index][1] = cStart;
                    index++;
                }
            }
            rStart -= qadam;
            qadam++;
            y = 1;

        }
        return res;
    }
}
