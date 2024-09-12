public class L_1700 {
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }


    public static int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        int b = 0;
        boolean bor = true;
        while (bor && b < n) {
            bor = false;
            for (int i = 0; i < n && b < n; i++) {
                if (students[i] == sandwiches[b]) {
                    b++;
                    students[i] = -1;
                    bor = true;
                }
            }
        }
        return n - b;
    }
}
