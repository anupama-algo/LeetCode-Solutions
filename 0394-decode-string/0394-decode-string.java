class Solution {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                numbers.push(number);
                strings.push(current);

                number = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                int repeat = numbers.pop();
                StringBuilder previous = strings.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}