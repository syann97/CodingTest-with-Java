import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접 리스트 형태로 구현
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        } 
        
        
        
       
        // 각 전선 별 flood fill
        for (int i = 0; i < wires.length; i++) {
            int[] cut = wires[i];
            
            // dfs 수행
            int count = dfs(1, cut, new boolean[n+1]);
            int other = n - count;
            // 송전탑 차이 계산
            answer = Math.min(answer, Math.abs(count - other));
        }
        
        
        return answer;
    }
    
    static int dfs(int v, int[] cut, boolean[] visited) {
        visited[v] = true;
        
        int count = 1;
        for (int nv : graph[v]) {
            if ((v == cut[0] && nv == cut[1]) || (v == cut[1] && nv == cut[0])) continue;
            if (!visited[nv]) {
                count += dfs(nv, cut, visited);
            }
        }
        
        return count;
    }
}