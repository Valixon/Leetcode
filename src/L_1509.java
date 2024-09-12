public class L_1509 {
    public static void main(String[] args) {
//        System.out.println(minDifference(new int[]{5, 3, 2, 4}));
//        System.out.println(minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(minDifference(new int[]{20, 66, 68, 57, 45, 18, 42, 34, 37, 58}));
    }

    public static int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        int res = 0;
        int[] a = new int[4];
        a[0] = a[1] = a[2] = a[3] = Integer.MIN_VALUE;
        int[] b = new int[4];
        b[0] = b[1] = b[2] = b[3] = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i >= a[0]) { a[3] = a[2]; a[2] = a[1]; a[1] = a[0]; a[0] = i;
            } else if (i >= a[1]) { a[3] = a[2]; a[2] = a[1]; a[1] = i;
            } else if (i >= a[2]) { a[3] = a[2];a[2] = i;
            } else if (i >= a[3]) {a[3] = i; }

            if (b[0] >= i) { b[3] = b[2]; b[2] = b[1]; b[1] = b[0]; b[0] = i;
            } else if (b[1] >= i) { b[3] = b[2]; b[2] = b[1]; b[1] = i;
            } else if (b[2] >= i) { b[3] = b[2]; b[2] = i;
            } else if (b[3] >= i) {b[3] = i; }
        }
        res = a[0] - a[3];
        for (int i = 1; i < 4; i++) {
            res = Math.min(res, a[i] - b[3 - i]);
        }
        return res;
    }
}