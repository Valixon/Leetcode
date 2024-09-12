import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ACMP_791 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        Set<String> one = new HashSet<>();
        names.add("Valixon");
        names.add("Ixtiyor");
        names.add("Temurbek");
        names.add("Javohir");
        names.add("Sardorbek");
//        names.add("Islomjon");
        names.add("Quvondiq");
        names.add("Xurshidbek");
        names.add("Nodirbek");
        names.add("Shamshod");
        names.add("Ibratbek");
        names.add("Akbarjon");
        names.add("Kamronbek");
//        names.add("Mirshod");
        while (one.size() != 6) {
            one.add(names.get(ThreadLocalRandom.current().nextInt(0, 12)));
        }
        names.removeAll(one);
        System.out.println(names);
        System.out.println(one);
    }
}