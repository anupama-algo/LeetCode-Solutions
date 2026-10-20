import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                first.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                second.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        return result;
    }
}