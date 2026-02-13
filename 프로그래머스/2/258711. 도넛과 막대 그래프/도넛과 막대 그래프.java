import java.util.*;


class Solution {
    public int[] solution(int[][] edges) {
        
        int[][] degrees = new int[2][1000001];
        boolean[] visited = new boolean[1000001];
        
        
        for (int[] edge : edges) {
            int out = edge[0];
            int in = edge[1];
            
            if (!visited[out]) visited[out] = true;
            if (!visited[in]) visited[in] = true;
            
            degrees[1][out]++;
            degrees[0][in]++;
        }
        
        
        
        int[] answer = new int[4];
        for (int u = 1; u <= 1000000; u++) {
            if (!visited[u]) continue;
            
            if (degrees[0][u] == 0 && degrees[1][u] >= 2) answer[0] = u;
            else if (degrees[1][u] == 0) answer[2]++;
            else if (degrees[1][u] == 2) answer[3]++;
        }
        
        answer[1] = degrees[1][answer[0]] - answer[2] - answer[3];
        
        return answer;
    }
}