import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(
                new int[]{time[1], time[2]}
            );
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[1], b[1]));

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];

                int newDistance = distance + weight;

                if (newDistance < dist[next]) {
                    dist[next] = newDistance;
                    pq.offer(new int[]{next, newDistance});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}