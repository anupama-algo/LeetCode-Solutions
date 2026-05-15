class Solution:
    def intToRoman(self, num: int) -> str:
        # Define mappings for standard and subtractive cases
        val_map = [
            (1000, "M"), (900, "CM"), (500, "D"), (400, "CD"),
            (100, "C"), (90, "XC"), (50, "L"), (40, "XL"),
            (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I")
        ]
        
        roman_num = ""
        
        for value, symbol in val_map:
            # Determine how many times the symbol fits into the current num
            count = num // value
            roman_num += symbol * count
            # Reduce num by the amount represented by the symbols added
            num %= value
            
        return roman_num