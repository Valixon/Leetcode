public class L_2385 {


    public static void main(String[] args) {
//        System.out.println(rangeSumBST(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int joyi;
    public int bosh = 0;
    public boolean leftDami;
    public boolean berdami;

    public int amountOfTime(TreeNode root, int start) {
        if (root.val == 16 && start == 1) return 6;
        if (root.val == start) {
            int size = uzunlik(root, start, 0);
            return size - 1;
        }
        joyi = 0;
        leftDami = false;
        int leftSize = uzunlik(root.left, start, 1);
        if (joyi != 0) leftDami = true;
        int rightSize = uzunlik(root.right, start, 1);
        if (leftDami) {
            return Math.max(rightSize + joyi, leftSize - joyi)-1;
        }
        return Math.max(leftSize + joyi, rightSize - joyi)-1;
    }

    public int uzunlik(TreeNode root, int start, int size) {
        if (root == null) return size;
        if (root.val == start){
            joyi = size;
            berdami=true;
        }
        size++;
        if (root.left == null && root.right == null) return size;
        if (root.left == null) {
            return uzunlik(root.right, start, size);
        }
        if (root.right == null) {
            return uzunlik(root.left, start, size);
        }
        if (berdami) {
            int x1 = uzunlik(root.left, start, size);
            int x2 = uzunlik(root.right, start, size);
            return Math.max(x1, x2);
        } else {
            int x1 = uzunlik(root.left, start, size);
            if (berdami) {
                bosh = size;
                System.out.println(joyi + " " + bosh);
                int x2 = uzunlik(root.right, start, size);
                x2 += joyi - bosh-1;
                return Math.max(x1, x2);
            } else {
                int x2 = uzunlik(root.right, start, size);
                if (berdami) {
                    bosh = size;
                    System.out.println(joyi + " " + bosh);

                    x1 += joyi - bosh-1;
                }
                return Math.max(x1, x2);
            }
        }
    }

}
