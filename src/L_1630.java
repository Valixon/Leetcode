import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_1630 {
    public static void main(String[] args) {
        System.out.println(checkArithmeticSubarrays(new int[]{207, -144, -648, 730, 511, 365, 584, 657, 73, 292, 146, 219, 438, 609, 174, 87, -438, -730, -73, -511, 65, 91, 117, -256, -384, -576, -64, -252, -210, -378, -84, -336, -42, -126, -168, -420, -294, -159, -106, -212, -530, -318, -265, 144, 108, 288, 216, 72, 360, 324, 180, 36, 252, -190, 261, -56, -504, -112, -168, -280, 485, 97, 873, 388, 582, 194, 679, 776, 291, 970, -61, -244, -427, -183, 207, -20, -60, -90, -40, -10, -100, -50, -30, -70, -80, -36, -284, 525, -52, -208, -312, -740, -592, -32, -128, -320, -256, -168, -112, -252, -56, -280, -84, -140, -28, -224, -196, 261, -310, -620, -558, -248, -372, -434, -124, -62, 267, 89, 178, -120, -144, -72, 98, 294, 196, 490, 980, 392, 588, 350, 315, 210, 140, 105, 35, 280, 70, 245, 175, 144, 83, 249, 747, 498, 166, 581, 830, 415, 664, 332, 332, 581, 747, 249, 166, 415, 83, 830, 498, 664, 6, -648, -324, -162, -567, -243, -810, -729, -405, -480, -192, -96, -288, -384, 96, 48, -232, -348, -116, -290, -406, -174, -580, -522, -464, 12, 16, 8, 987}, new int[]{149}, new int[]{151}));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int[][] hammasi = new int[nums.length][nums.length];
        for (int i = 0; i < l.length; i++) {
            int li = l[i];
            int ri = r[i];
            boolean h = false;
            if (hammasi[li][ri] == 0) {
                int[] a = new int[ri - li + 1];
                int index = 0;
                for (int j = li; j <= ri; j++) {
                    a[index++] = nums[j];
                }
                h = qarabKorQani(a);
                hammasi[li][ri] = h ? 2 : 1;
            } else {
                h = hammasi[li][ri] == 2;
            }
            result.add(h);
        }
        return result;
    }

    public static boolean qarabKorQani(int[] a) {
        if (a.length <= 1) return false;
        Arrays.sort(a);
        int x = a[1] - a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] != x) return false;
        }
        return true;
    }
}