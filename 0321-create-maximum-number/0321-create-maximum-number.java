class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {
            int[] a = maxSubsequence(nums1, i);
            int[] b = maxSubsequence(nums2, k - i);
            int[] merged = merge(a, b);

            if (greater(merged, 0, best, 0)) {
                best = merged;
            }
        }

        return best;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0;
        int drop = nums.length - k;

        for (int num : nums) {
            while (top > 0 && drop > 0 && stack[top - 1] < num) {
                top--;
                drop--;
            }

            if (top < k) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a.length || j < b.length) {
            if (greater(a, i, b, j)) {
                result[index++] = a[i++];
            } else {
                result[index++] = b[j++];
            }
        }

        return result;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}