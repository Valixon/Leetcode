public class L_731 {
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
    }


    static class MyCalendarTwo {
        private int[][] a;
        private int index;

        public MyCalendarTwo() {
            a = new int[100000][3];
            index = 0;
        }

        public boolean book(int start, int end) {
            if (start == end) return true;
            System.out.println("Keldi " + start + " " + end);
            for (int i = 0; i < index; i++) {
                System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2] + " ");
            }
            for (int i = 0; i < index; i++) {
                if (a[i][0] == start && a[i][1] == end) {
                    if (a[i][2] == 2) return false;
                    a[i][2]++;
                    System.out.println("0");
                    return true;
                }
            }
            for (int i = 0; i < index; i++) {
                if (a[i][0] == a[i][1]) continue;
                if (a[i][0] <= start && end <= a[i][1]) {
                    System.out.println("1");
                    if (a[i][2] == 2) return false;
                    a[index][0] = a[i][0];
                    a[index][1] = start;
                    a[index][2] = a[i][2];
                    index++;
                    a[index][0] = end;
                    a[index][1] = a[i][1];
                    a[index][2] = a[i][2];
                    index++;
                    a[i][0] = start;
                    a[i][1] = end;
                    a[i][2]++;
                    return true;
                }
                if (start <= a[i][0] && a[i][1] < end) {
                    System.out.println("2");
                    if (a[i][2] == 2) return false;
                    a[i][2]++;
                    if (book(start, a[i][0]) && book(a[i][1], end)) {
                        return true;
                    } else {
                        a[i][2]--;
                        return false;
                    }
                }
                if (a[i][0] <= start && a[i][1] > start && a[i][1] <= end) {
                    System.out.println("3");
                    if (a[i][2] == 2) return false;
                    a[index][0] = a[i][0];
                    a[index][1] = start;
                    a[index][2] = a[i][2];
                    index++;
                    a[i][0] = start;
                    a[i][2]++;
                    if (book(a[i][1], end)) {
                        return true;
                    } else {
                        a[i][2]--;
                        return false;
                    }
                }
                if (start <= a[i][0] && end > a[i][0] && end <= a[i][1]) {
                    System.out.println("4");
                    if (a[i][2] == 2) return false;
                    a[index][0] = end;
                    a[index][1] = a[i][1];
                    a[index][2] = a[i][2];
                    index++;
                    a[i][1] = end;
                    a[i][2]++;
                    if (book(start, a[i][0])) {
                        return true;
                    } else {
                        a[i][2]--;
                        return false;
                    }
                }
            }
            a[index][0] = start;
            a[index][1] = end;
            a[index][2] = 1;
            index++;
            System.out.println("5");
            return true;
        }
    }
}
