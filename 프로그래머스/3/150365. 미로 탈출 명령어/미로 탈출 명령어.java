import java.util.*;

class Solution {
    static String answer;
    static int[][] dist;
    
    // d l r u
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};
    static char[] directions = {'d', 'l', 'r', 'u'};
    static int N;
    static int M;
    static int sy, sx, ey, ex;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        init(n, m, x, y, r, c, k);
        if (answer == null) {
            answer = "test";
        }
        
        if (dist[sy][sx] > k) return "impossible";
        // int k, int y, int x, StringBuilder sb, boolean[][] visited
        return dfs(k, sy, sx, new StringBuilder()) ? answer : "impossible";
    }    
    
    static boolean dfs(int k, int y, int x, StringBuilder sb) {
        if (k == 0 && y == ey && x == ex) {
            answer = sb.toString();
            return true;
        }
        
    
        if (dist[y][x] > k || (k - dist[y][x]) % 2 != 0) return false;
        
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                sb.append(directions[d]);
                if (dfs(k - 1, ny, nx, sb)) return true;                
                sb.setLength(sb.length() - 1);
            }
        }
        
        return false;
    }
    
    static void init(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        dist = new int[N][M];
        
        sy = x - 1;
        sx = y - 1;
        ey = r - 1;
        ex = c - 1;
        
        fillDist();
    }
    
    static void fillDist() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
               dist[y][x] = Math.abs(ey - y) + Math.abs(ex - x);
            }
        }
    }
}