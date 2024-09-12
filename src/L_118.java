import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_118 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(generate(sc.nextInt()));

    }

    public static List<Integer> generate(int numRows) {
        numRows++;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(1);
        result.add(line);
        List<Integer> newLine = new ArrayList<>();
        for (int i = 2; i <= numRows; i++) {
            newLine.add(1);
            for (int j = 0; j < line.size() - 1; j++) {
                newLine.add(line.get(j) + line.get(j + 1));
            }
            newLine.add(1);
            result.add(newLine);
            line = new ArrayList<>(newLine);
            newLine = new ArrayList<>();
        }
        return result.get(numRows-1);
    }
}