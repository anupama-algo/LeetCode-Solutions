import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                char[] chars = current.toCharArray();

                for (int j = 0; j < 4; j++) {
                    char original = chars[j];

                    for (int change : new int[]{-1, 1}) {
                        int digit = (original - '0' + change + 10) % 10;
                        chars[j] = (char) ('0' + digit);

                        String next = new String(chars);

                        if (!dead.contains(next) && visited.add(next)) {
                            queue.offer(next);
                        }
                    }

                    chars[j] = original;
                }
            }

            moves++;
        }

        return -1;
    }
}