import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthLargest {


    public static void main(String[] args) {
    }

    public static int k;
    public static ArrayList<Integer> liist;

    public KthLargest(int k, int[] nums) {
        liist  = new ArrayList<>();
        this.k = k;
       for (int num:nums){
           liist.add(num);
       }
    }

    public static int add(int val) {
        liist.add(val);
        Collections.sort(liist);
        return liist.get(liist.size()-k);
    }
}