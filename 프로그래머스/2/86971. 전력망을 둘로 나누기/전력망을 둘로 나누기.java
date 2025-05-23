import java.util.*;

class Solution {
    static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        int min = n;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int[] cut = wires[i];
            int count = dfs(1, new boolean[n+1], cut);
            int other = n - count;
            min = Math.min(min, Math.abs(count - other));
        }
        return min;
    }
    
    static int dfs(int v, boolean[] visited, int[] cut) {
        visited[v] = true;
        
        int count = 1;
        
        for (int nv : graph[v]) {
            if ((v == cut[0] && nv == cut[1]) || (v == cut[1] && nv == cut[0])) continue;
            if (!visited[nv]) {
                count += dfs(nv, visited, cut);
            }
        }
        return count;
    }
}