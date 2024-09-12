class DaysOfWeek {//open main class

    public static void main(String args[]) {//open main method

        Days DOTW = new Days();
        DOTW.Disp_Days();

    }//close main method
}//open main class

class Days {//open class    //class for arrays

    String DOW[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    String Days(int index) {
        return DOW[index];
    }

    void Disp_Days() {//open method

        for (int c = 1; c < 4; c++) {//open for loop 1
            System.out.println("**********");
            System.out.println("WEEK " + c);
            System.out.println("**********");

            for (int d = 0; d < 7; d++) {//open for loop 2
                System.out.println(Days(d));
            }//close for loop 2

        }//close for loop 1

    }//close method
}//close class