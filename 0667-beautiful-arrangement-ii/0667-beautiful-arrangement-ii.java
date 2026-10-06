class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int left = 1;
        int right = n;
        int index = 0;

        while (left <= right) {
            if (k > 1) {
                if (k % 2 == 1) {
                    result[index++] = left++;
                } else {
                    result[index++] = right--;
                }
                k--;
            } else {
                result[index++] = left++;
            }
        }

        return result;
    }
}