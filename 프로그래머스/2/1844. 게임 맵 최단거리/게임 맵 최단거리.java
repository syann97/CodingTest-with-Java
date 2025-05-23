import java.util.*;

class Node {
    int y;
    int x;
    int dist;
    
    public Node (int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

class Solution {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        return bfs(maps);
    }
    
    
    
    static int bfs(int[][] maps) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int dist = node.dist;
            
            if (y == N-1 && x == M-1) return dist + 1;
            
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (0 <= ny && ny < N && 0 <= nx && nx < M && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx, dist + 1));
                }
            }
        }
        
        
        
        return -1;
    }
}