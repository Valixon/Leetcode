import java.util.Scanner;

public class L_2652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sumOfMultiples(sc.nextInt()));
    }

    public static int sumOfMultiples(int n) {
        return (((1 + (n / 3)) * (n / 3)) / 2) * 3
                + (((1 + (n / 5)) * (n / 5)) / 2) * 5
                + (((1 + (n / 7)) * (n / 7)) / 2) * 7
                - (((1 + (n / 15)) * (n / 15)) / 2) * 15
                - (((1 + (n / 21)) * (n / 21)) / 2) * 21
                - (((1 + (n / 35)) * (n / 35)) / 2) * 35
                + (((1 + (n / 105)) * (n / 105)) / 2) * 105;
    }
}
/*
3
JFK KUL
JFK NRT
NRT JFK

5
JFK SFO
JFK ATL
SFO ATL
ATL JFK
ATL SFO

JFK ATL SFO ATL JFK SFO

7
JFK ATL
ORD PHL
JFK ORD
PHX LAX
LAX JFK
PHL ATL
ATL PHX


6
29 51 87 87 72 12

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

