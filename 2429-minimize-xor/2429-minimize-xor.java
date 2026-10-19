
class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = Integer.bitCount(num2);
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {
            if ((num1 & (1 << bit)) != 0 && targetBits > 0) {
                result |= 1 << bit;
                targetBits--;
            }
        }

        for (int bit = 0; bit <= 30 && targetBits > 0; bit++) {
            if ((result & (1 << bit)) == 0) {
                result |= 1 << bit;
                targetBits--;
            }
        }

        return result;
    }
}
