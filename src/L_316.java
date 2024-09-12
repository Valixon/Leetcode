import java.util.Scanner;
import java.util.Stack;

public class L_316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((int) 'a');
        System.out.println(removeDuplicateLetters(sc.next()));
    }

    public static String removeDuplicateLetters(String s) {
        char[] a = s.toCharArray();
        int[] soni = new int['z' + 1];
        boolean[] ishlatildi = new boolean['z' + 1];
        for (char c : a) {
            soni[c]++;
        }
        Stack<Character> result = new Stack<>();
        result.push(a[0]);
        ishlatildi[a[0]] = true;
        soni[a[0]]--;
        for (int i = 1; i < a.length; i++) {
            char x = a[i];
            if (ishlatildi[x]) {
                soni[x]--;
                continue;
            }
            while (!result.isEmpty() && result.lastElement() > x && soni[result.lastElement()] > 0) {
                ishlatildi[result.pop()] = false;
            }
            result.push(x);
            ishlatildi[x] = true;
            soni[x]--;
        }
        StringBuilder sBuilder = new StringBuilder();
        for (Character res : result) {
            sBuilder.append(res);
        }
        return sBuilder.toString();
    }
}
