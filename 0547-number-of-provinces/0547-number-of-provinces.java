class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int provinces = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1 &&
                    find(parent, i) != find(parent, j)) {

                    parent[find(parent, i)] = find(parent, j);
                    provinces--;
                }
            }
        }

        return provinces;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }
}