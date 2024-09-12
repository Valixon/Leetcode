import java.util.ArrayList;
import java.util.List;

public class L_1002 {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }


    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        for (char i : words[0].toCharArray()) {
            boolean t = false;
            for (int j = 1; j < words.length; j++) {
                if (words[j].indexOf(i) > -1) {
                    words[j] = words[j].replaceFirst(i + "", "");
                } else {
                    t = true;
                    break;
                }
            }
            if (!t) {
                res.add(i + "");
            }
        }
        return res;
    }
}