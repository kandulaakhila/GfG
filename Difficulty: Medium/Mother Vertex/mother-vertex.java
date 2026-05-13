import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // Step 0: Build adjacency list from edges
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]); // directed edge u->v
        }

        boolean[] visited = new boolean[V];
        int lastFinished = -1;

        // Step 1: Find last finished vertex using DFS
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, adj, visited);
                lastFinished = v; // record last finished
            }
        }

        // Step 2: Verify candidate
        Arrays.fill(visited, false);
        dfs(lastFinished, adj, visited);

        for (boolean b : visited) {
            if (!b) return -1; // candidate fails
        }

        // Step 3: Check smaller vertices (ensure smallest mother vertex)
        int answer = lastFinished;
        for (int v = 0; v <= lastFinished; v++) {
            Arrays.fill(visited, false);
            dfs(v, adj, visited);
            boolean allVisited = true;
            for (boolean b : visited) {
                if (!b) {
                    allVisited = false;
                    break;
                }
            }
            if (allVisited) {
                answer = v; // smallest found
                break;
            }
        }
        return answer;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true; // mark current node
        for (int nei : adj.get(node)) { // explore neighbors
            if (!visited[nei]) dfs(nei, adj, visited);
        }
    }
}
