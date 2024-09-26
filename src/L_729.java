import java.lang.reflect.Array;
import java.util.Arrays;

public class L_729 {
    private int[][] a;
    private int index;

    public void MyCalendar() {
        a = new int[1001][2];
        index = 0;
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < index; i++) {
            if ((a[i][0] <= start && start < a[i][1])
                    || (a[i][0] >= start && a[i][0] < end)) {
                return false;
            }
        }
        a[index][0] = start;
        a[index][1] = end;
        index++;

        return true;
    }
}
