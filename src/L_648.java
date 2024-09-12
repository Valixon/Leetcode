import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L_648 {

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }


    public static String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        sentence = " " + sentence;
        for (String dic : dictionary) {
            sentence = sentence.replaceAll(" " + dic + "\\w+", " " + dic);
        }
        return sentence.substring(1);
    }
}