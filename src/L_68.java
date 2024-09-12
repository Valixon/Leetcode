import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxWidth = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        System.out.println(fullJustify(words, maxWidth));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int i = 0;
        int lineLength = 0;
        int n = words.length;
        while (i < n) {
            if (lineLength != 0) {
                lineLength++;
            }
            if (words[i].length() + lineLength <= maxWidth) {
                line.add(words[i]);
                lineLength += words[i].length();
                i++;
            } else {
                if (line.size() != 1) lineLength--;
                int x = maxWidth - lineLength;
                int p = x / Math.max(1, line.size() - 1);
                int q = x % Math.max(1, line.size() - 1);
                StringBuilder lineString = new StringBuilder();
                for (String s : line) {
                    lineString.append(s);
                    lineString.append(" ".repeat(Math.max(0, p + 1)));
                    if (q > 0) {
                        lineString.append(" ");
                        q--;
                    }
                }
                result.add(lineString.substring(0, maxWidth));
                lineLength = 0;
                line = new ArrayList<>();
            }

        }
        if (!line.isEmpty()) {
            StringBuilder lineString = new StringBuilder();
            for (String s : line) {
                lineString.append(s).append(" ");
            }
            lineString.append(" ".repeat(maxWidth));
            result.add(lineString.substring(0, maxWidth));
        }

        return result;
    }
}
// This is an example of text justification.
// What must be acknowledgment shall be