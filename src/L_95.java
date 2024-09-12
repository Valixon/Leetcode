import java.util.*;
import java.util.stream.Collectors;

public class L_95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<TreeNode> result = generateTrees(a);
        for (TreeNode treeNode : result) {
            System.out.println(treeNode);
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        TreeSet<Integer> numbers = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        ArrayList<TreeNode> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.remove(i);
            int finalI = i;
            List<TreeNode> s = yechim(i, n, numbers.stream().filter(son -> son < finalI).collect(Collectors.toSet()), numbers.stream().filter(son -> son > finalI).collect(Collectors.toSet()));
            result.addAll(s);
            numbers.add(i);
        }
        return result;
    }

    public static List<TreeNode> yechim2(int i, int n, Set<Integer> leftNumbers, Set<Integer> rightNumbers) {
        if (leftNumbers.isEmpty() && rightNumbers.isEmpty()) {
            TreeNode treeNode = new TreeNode(i);
            return List.of(treeNode);
        }
        if (leftNumbers.isEmpty()) {
            TreeSet<Integer> rr2 = new TreeSet<>(rightNumbers);
            ArrayList<TreeNode> result2 = new ArrayList<>();
            for (Integer b : rightNumbers) {
                rr2.remove(b);
                List<TreeNode> mov = yechim(b, n, rr2.stream().filter(son -> son < b).collect(Collectors.toSet()), rr2.stream().filter(son -> son > b).collect(Collectors.toSet()));
                rr2.add(b);
                for (TreeNode s : mov) {
                    result2.add(new TreeNode(i, null, s));
                }
            }
            return result2;

        }
        if (rightNumbers.isEmpty()) {
            TreeSet<Integer> rr2 = new TreeSet<>(leftNumbers);
            ArrayList<TreeNode> result2 = new ArrayList<>();
            for (Integer b : leftNumbers) {
                rr2.remove(b);
                List<TreeNode> mov = yechim(b, n, rr2.stream().filter(son -> son < b).collect(Collectors.toSet()), rr2.stream().filter(son -> son > b).collect(Collectors.toSet()));
                rr2.add(b);
                for (TreeNode s : mov) {
                    result2.add(new TreeNode(i, s, null));
                }
            }
            return result2;
        }
        TreeSet<Integer> ll2 = new TreeSet<>(leftNumbers);
        TreeSet<Integer> rr2 = new TreeSet<>(rightNumbers);
        ArrayList<TreeNode> result2 = new ArrayList<>();
        ArrayList<TreeNode> result3 = new ArrayList<>();

        for (Integer le : leftNumbers) {
            ll2.remove(le);
            List<TreeNode> mov = yechim(le, n, ll2.stream().filter(son -> son < le).collect(Collectors.toSet()), ll2.stream().filter(son -> son > le).collect(Collectors.toSet()));
            for (Integer re : rightNumbers) {
                rr2.remove(re);
                List<TreeNode> mov2 = yechim(re, n, rr2.stream().filter(son -> son < re).collect(Collectors.toSet()), rr2.stream().filter(son -> son > re).collect(Collectors.toSet()));
                rr2.add(re);
                for (TreeNode s : mov) {
                    for (TreeNode s2 : mov2) {
                        result2.add(new TreeNode(i, s, s2));
                    }
                }
            }
            ll2.add(le);
        }
        return result2;
    }

    public static List<TreeNode> yechim(int i, int n, Set<Integer> leftNumbers, Set<Integer> rightNumbers) {
        List<TreeNode> result = new ArrayList<>();

        if (leftNumbers.isEmpty() && rightNumbers.isEmpty()) {
            TreeNode treeNode = new TreeNode(i);
            result.add(treeNode);
            return result;
        }

        Integer[] leftArray = leftNumbers.toArray(new Integer[0]);
        Integer[] rightArray = rightNumbers.toArray(new Integer[0]);

        if (leftNumbers.isEmpty()) {
            for (Integer b : rightNumbers) {
                Set<Integer> filteredRight = new HashSet<>();
                for (Integer son : rightArray) {
                    if (son < b) {
                        filteredRight.add(son);
                    }
                }
                List<TreeNode> mov = yechim(b, n, Collections.emptySet(), filteredRight);
                for (TreeNode s : mov) {
                    result.add(new TreeNode(i, null, s));
                }
            }
            return result;
        }

        if (rightNumbers.isEmpty()) {
            for (Integer b : leftNumbers) {
                Set<Integer> filteredLeft = new HashSet<>();
                for (Integer son : leftArray) {
                    if (son < b) {
                        filteredLeft.add(son);
                    }
                }
                List<TreeNode> mov = yechim(b, n, filteredLeft, Collections.emptySet());
                for (TreeNode s : mov) {
                    result.add(new TreeNode(i, s, null));
                }
            }
            return result;
        }

        for (Integer le : leftNumbers) {
            Set<Integer> filteredLeft = new HashSet<>();
            Set<Integer> filteredRight1 = new HashSet<>();
            for (Integer son : leftArray) {
                if (son < le) {
                    filteredLeft.add(son);
                }
                if (son > le) {
                    filteredRight1.add(son);
                }
            }
            List<TreeNode> mov = yechim(le, n, filteredLeft, filteredRight1);
            for (Integer re : rightNumbers) {
                Set<Integer> filteredRight = new HashSet<>();
                Set<Integer> filteredRight2 = new HashSet<>();
                for (Integer son : rightArray) {
                    if (son < re) {
                        filteredRight.add(son);
                    }
                    if (son > le) {
                        filteredRight2.add(son);
                    }
                }
                List<TreeNode> mov2 = yechim(re, n, filteredRight, filteredRight2);
                for (TreeNode s : mov) {
                    for (TreeNode s2 : mov2) {
                        result.add(new TreeNode(i, s, s2));
                    }
                }
            }
        }
        return result;
    }

    public static class TreeNode {
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

        @Override
        public String toString() {
            return "t{" +
                    "v=" + val +
                    ", l=" + left +
                    ", r=" + right +
                    '}';
        }
    }
}
