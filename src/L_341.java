import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L_341 {
    public static void main(String[] args) {

    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> res = new ArrayList<>();
        int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    res.add(nestedInteger.getInteger());
                } else {
                    res.addAll(getJummi(nestedInteger.getList()));
                }
            }
        }

        private List<Integer> getJummi(List<NestedInteger> list) {
            List<Integer> res2 = new ArrayList<>();
            for (NestedInteger nestedInteger : list) {
                if (nestedInteger.isInteger()) {
                    res2.add(nestedInteger.getInteger());
                } else {
                    res2.addAll(getJummi(nestedInteger.getList()));
                }
            }
            return res2;
        }

        @Override
        public Integer next() {
            return res.get(index++);
        }

        @Override
        public boolean hasNext() {
            return res.size() > index;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}