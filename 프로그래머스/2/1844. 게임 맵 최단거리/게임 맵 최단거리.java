import java.util.*;

class Node {
    int y;
    int x;
    int dist;
    
    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        int ey = N - 1;
        int ex = M - 1;
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int dist = node.dist;
            
            if (y == ey && x == ex) return dist;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx, dist + 1));
                }
            }
        }
        return -1;
    }
}