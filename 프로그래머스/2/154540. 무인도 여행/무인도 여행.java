import java.util.*;

class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int N;
    static int M;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        ArrayList<Integer> tmp = new ArrayList<>();
        char[][] area = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && area[i][j] != 'X') {
                    tmp.add(dfs(visited, area, i, j, area[i][j] - '0'));
                }
            }
        }
        
        if (tmp.isEmpty()) {
            return new int[] {-1};
        }
        else {
            Collections.sort(tmp);
            int[] answer = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                answer[i] = tmp.get(i);
            }
            return answer;
        }
    }
    
    static int dfs(boolean[][] visited, char[][] area, int y, int x, int count) {
        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && area[ny][nx] != 'X') {
                count = dfs(visited, area, ny, nx, count + (area[ny][nx] - '0'));
            }
        }
        return count;
    }
}