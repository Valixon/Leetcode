public class L_1574 {

    public static void main(String[] args) {
//        System.out.println(findLengthOfShortestSubarray(new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15}));
//        System.out.println(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{2, 1}));
    }


    public static int findLengthOfShortestSubarray(int[] arr) {
        int usadi = 0;
        int kamayadi = 0;
        int old = -1;
        for (int num : arr) {
            if (old <= num) {
                usadi++;
                old = num;
            } else {
                break;
            }
        }
        old = 1000000001;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (old >= arr[i]) {
                kamayadi++;
                old = arr[i];
            } else {
                break;
            }
        }
        if (usadi == arr.length) return 0;
        if (kamayadi == arr.length) return arr.length - 1;
        int max = kamayadi;
        while (usadi > 0) {
            int y = usadi + kamayadi;
            int last = arr[usadi - 1];
            usadi--;
            for (int i = arr.length - kamayadi; i < arr.length; i++) {
                if (arr[i] < last) {
                    y--;
                } else {
                    break;
                }
            }
            max = Math.max(y, max);
        }

        return arr.length - max;
    }
}