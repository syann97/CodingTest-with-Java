import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        int answer = n;
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접 리스트 형태로 그래프 저장
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        
        // flood fill 수행
        for (int i = 0; i < wires.length; i++) {
            int[] cut = wires[i];
            boolean[] visited = new boolean[n+1];
            
            int count = dfs(1, visited, cut);
            int other = n - count;
            answer = Math.min(answer, Math.abs(count - other));
        }
        return answer;
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