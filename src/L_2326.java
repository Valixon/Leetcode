public class L_2326 {
    public static void main(String[] args) {
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[i][j] = -1;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int up = n - 1;
        while (head != null) {
            try {
                for (int i = left; i <= right; i++) {
                    res[top][i] = head.val;
                    head = head.next;
                }
                top++;
                for (int i = top; i <= up; i++) {
                    res[i][right] = head.val;
                    head = head.next;
                }
                right--;
                for (int i = right; i >= left; i--) {
                    res[up][i] = head.val;
                    head = head.next;
                }
                up--;
                for (int i = up; i >= top; i--) {
                    res[i][left] = head.val;
                    head = head.next;
                }
                left++;
            } catch (NullPointerException ex) {
                return res;
            }
        }
        return res;
    }

}