class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0;
        int right = 0;

        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long children = 0;

            for (int candy : candies) {
                children += candy / mid;
            }

            if (children >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}