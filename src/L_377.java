import java.util.*;

public class L_377 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int target = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
        System.out.println(combinationSum4(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650, 660, 670, 680, 690, 700, 710, 720, 730, 740, 750, 760, 770, 780, 790, 800, 810, 820, 830, 840, 850, 860, 870, 880, 890, 900, 910, 920, 930, 940, 950, 960, 970, 980, 990, 111}, 999));

    }

    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        List<List<Integer>> listSet = new ArrayList<>();
        List<Integer> ishlatildi = new ArrayList<>();
        TreeSet<Integer> foydasiz = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            sum = nums[i];
            ishlatildi.add(nums[i]);
            generate(sum, target, i, nums, ishlatildi, listSet, foydasiz);
            ishlatildi = new ArrayList<>();
        }

        long javob = 0;
        for (int i = 0; i < listSet.size(); i++) {
            List<Integer> hammasi = listSet.get(i);
            TreeSet<Integer> uniqlari = new TreeSet<>(hammasi);
            int[] a = new int[uniqlari.size()];
            int index = 0;
            for (Integer son : uniqlari) {
                for (Integer tak : hammasi) {
                    if (son == tak) {
                        a[index]++;
                    }
                }
                index++;
            }
            javob += hisobla(hammasi.size(), a);
        }

        return Integer.parseInt(String.valueOf(javob));
    }

    private static long hisobla(int size, int[] a) {
        long kop = 1;
        Arrays.sort(a);
        for (int i = a[a.length - 1] + 1; i <= size; i++) {
            kop = kop * (long) i;
        }
        for (int i = 0; i <= a.length - 2; i++) {
            for (int j = 1; j <= a[i]; j++) {
                kop = kop / (long) (j);
            }
        }
        return kop;
    }

    public static void generate(int sum, int target, int index, int[] nums, List<Integer> ishlatildi, List<List<Integer>> listSet, TreeSet<Integer> foydasiz) {
        if (sum == target) {
            listSet.add(new ArrayList<>(ishlatildi));
        }
        if (foydasiz.contains(sum*(index+1))) return;
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
                sum += nums[i];
                ishlatildi.add(nums[i]);
                generate(sum, target, i, nums, ishlatildi, listSet, foydasiz);
                ishlatildi.remove(ishlatildi.size() - 1);
                sum -= nums[i];
            } else {
                foydasiz.add(sum*(index+1));
                break;
            }
        }
    }
}