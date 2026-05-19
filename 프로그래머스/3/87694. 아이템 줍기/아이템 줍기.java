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
    static boolean[][] surface;
    static boolean[][] isRectangleArea;
    static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
    static int R;
    static int C;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        init(rectangle);
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    // surface 구하기
    static void init(int[][] rectangle) {
        R = 0;
        C = 0;
        // (x, y)
        
        for (int[] arr : rectangle) {
            C = Math.max(C, arr[2]*2);
            R = Math.max(R, arr[3]*2);
        }
        
        isRectangleArea = new boolean[R+2][C+2];
        surface = new boolean[R+2][C+2];
        
        for (int[] arr : rectangle) {
            for (int row = arr[1]*2; row <= arr[3]*2; row++) {
                for (int col = arr[0]*2; col <= arr[2]*2; col++) {
                    isRectangleArea[row][col] = true;
                }
            }
        }
        
        dfs(0, 0, new boolean[R+2][C+2]);
        
        for (int i = 0; i <= R+1; i++) {
            for (int j = 0; j <= C+1; j++) {
                System.out.print(surface[i][j] ? "O " : "X ");
            }
            System.out.println();
        }
    }
    
    static void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        
        for (int d = 0; d < 8; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (ny < 0 || ny > R+1 || nx < 0 || nx > C+1) continue;
            
            if (isRectangleArea[ny][nx]) {
                surface[ny][nx] = true;
            }
            else if (!visited[ny][nx]) {
                dfs(ny, nx, visited);
            }
        }
    }
    
    static int bfs(int sx, int sy, int ex, int ey) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(sy, sx, 0));
        
        boolean[][] visited = new boolean[R+2][C+2];
        visited[sy][sx] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int dist = node.dist;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (ny < 0 || ny > R+1 || nx < 0 || nx > C+1) continue;
                if (visited[ny][nx] || !surface[ny][nx]) continue;
                if (ny == ey && nx == ex) return (dist + 1) / 2;
                
                visited[ny][nx] = true;
                q.offer(new Node(ny, nx, dist + 1));
            }
        }
        return 0;
    }
}