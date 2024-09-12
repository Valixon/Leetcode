public class L_2849 {
    public static void main(String[] args) {
//        System.out.println(eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
//        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(isReachableAtTime(3, 1, 7, 3, 3));
    }

    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int q = Math.max(Math.abs(fx - sx), Math.abs(fy - sy));
        if (q == 0 && t == 1) {
            return false;
        }
        return q <= t;
    }

}
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]
//[1, 2, 2, 1, 2, 2, 2, 3, 4, 5, 6, 7, 4, 3, 5]