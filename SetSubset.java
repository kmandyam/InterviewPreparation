import java.util.*;

public class SetSubset {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);

        System.out.println(getAllSubsets(set));
    }

    public static Set<Set<Integer>> getAllSubsets(Set<Integer> set) {
        List<Integer> list_set = new ArrayList<Integer>(set);
        Set<Set<Integer>> subsets = new HashSet<Set<Integer>>();
        subsetHelper(list_set, new HashSet<>(), subsets);
        return subsets;
    }

    public static void subsetHelper(List<Integer> set, Set<Integer> acc, Set<Set<Integer>> subsets) {
        if (set.isEmpty()) {
            subsets.add(acc);
        } else {
            // choose the first element from the set
            Integer elt = set.get(0);
            Set<Integer> acc_with_elt = new HashSet<Integer>(acc);
            acc_with_elt.add(elt);
            Set<Integer> acc_without_elt = new HashSet<Integer>(acc);

            set.remove(0);

            List<Integer> newList1 = new ArrayList<Integer>(set);
            List<Integer> newList2 = new ArrayList<Integer>(set);


            subsetHelper(newList1, acc_with_elt, subsets);
            subsetHelper(newList2, acc_without_elt, subsets);
        }
    }
}