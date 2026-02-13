import java.util.*;


class Solution {
    public int[] solution(int[][] edges) {
        
        int[][] degrees = new int[1000001][2];
        boolean[] visited = new boolean[1000001];
        
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            visited[u] = true;
            visited[v] = true;

            degrees[u][1]++;
            degrees[v][0]++;
        }
        
        
        int[] answer = new int[4];
        for (int u = 1; u <= 1000000; u++) {
            if (!visited[u]) continue;
            
            int in = degrees[u][0];
            int out = degrees[u][1];

            if (in == 0 && out >= 2) answer[0] = u;
            else if (out == 0) answer[2]++;
            else if (out == 2) answer[3]++;
        }
        
        answer[1] = degrees[answer[0]][1] - answer[2] - answer[3];
        
        return answer;
    }
}