public class L_85 {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }


    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int x = i;
                    int y = matrix[0].length - 1;
                    for (int k = i; k < matrix.length; k++) {
                        for (int l = j; l < y; l++) {
                            if (matrix[i][j] == '0') {
                                y = j;
                                max = Math.max(max, (k - i + 1) * (l - j + 1));
                            }
                        }
                    }
                    max = Math.max(max, (x - j) * (y - i));
                }
            }
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
        return max;
    }
}
