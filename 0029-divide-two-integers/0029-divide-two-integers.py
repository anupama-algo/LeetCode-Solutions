class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        # Constants for 32-bit integer limits
        MAX_INT = 2147483647
        MIN_INT = -2147483648

        # Handle overflow
        if dividend == MIN_INT and divisor == -1:
            return MAX_INT

        # Determine sign
        negative = (dividend < 0) != (divisor < 0)
        
        a, b = abs(dividend), abs(divisor)
        res = 0

        # Efficient subtraction using bit shifts
        while a >= b:
            temp, i = b, 1
            while a >= (temp << 1):
                temp <<= 1
                i <<= 1
            a -= temp
            res += i

        return -res if negative else res