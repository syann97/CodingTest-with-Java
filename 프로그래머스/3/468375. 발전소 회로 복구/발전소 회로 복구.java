import java.util.*;

class Node {
    int v;
    Node node;
    
    public Node (int v, Node node) {
        this.v = v;
        this.node = node;
    }
}

class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static final int MAX = 10000000;
    static int n, m, k, posX, posY;
    static int[][] dist;
    static int[][] panelDist;
    static Node[] graph;
    static int[] in;
    static String[] grid;
    static int[][] panels;
    static int[][] seqs;
    static boolean[][] visited;
    static int min;
    static int[][] dp;

    public int solution(int h, String[] g, int[][] p, int[][] s) {
        grid = g;
        panels = p;
        seqs = s;
        n = grid.length;
        m = grid[0].length();
        k = panels.length;
        
        visited = new boolean[n][m];
        dp = new int[1 << (k + 1)][k + 1];
        
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }
        
        setElevatorPos();
        setDistFromElevator();
        setPanelDist();
        setGraph();
        
        min = MAX;
        
        for (int v = 1; v <= k; v++) {
            if (in[v] == 0) {
                int bitmask = (1 << v);
                
                for (Node node = graph[v]; node != null; node = node.node) {
                    in[node.v]--;
                }
                
                dfs(panelDist[1][v], 1, v, bitmask);
                
                for (Node node = graph[v]; node != null; node = node.node) {
                    in[node.v]++;
                }
            }
        }
        return min;
    }
    
    static void dfs(int currentDist, int count, int u, int bitmask) {
        if (count == k) {
            min = Math.min(min, currentDist);
            return;
        }
        
        if (min <= currentDist) return;
        
        if (dp[bitmask][u] <= currentDist) return;
        dp[bitmask][u] = currentDist;
        
        for (int v = 1; v <= k; v++) {
            if (in[v] == 0 && (bitmask & (1 << v)) == 0) {
                for (Node node = graph[v]; node != null; node = node.node) {
                    in[node.v]--;
                }
                
                dfs(currentDist + panelDist[u][v], count + 1, v, bitmask | (1 << v));
                
                for (Node node = graph[v]; node != null; node = node.node) {
                    in[node.v]++;
                }
            }
        }
    }
    
    static void setElevatorPos() {
        for (int i = 0; i < n; i++) {
            String str = grid[i];
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '@') {
                    posY = i;
                    posX = j;
                    break;
                }
            }
        }
    }
    
    static void setDistFromElevator() {
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], MAX);
        }
        
        dist[posY][posX] = 0;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{posY, posX});
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (0 <= ny && ny < n && 0 <= nx && nx < m && grid[ny].charAt(nx) != '#' && dist[ny][nx] == MAX) {
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
    
    static void setPanelDist() {
        panelDist = new int[k+1][k+1];
        for (int i = 1; i <= k; i++) {
            for (int j = i + 1; j <= k; j++) {
                panelDist[i][j] = getDist(i, j);
                panelDist[j][i] = panelDist[i][j];
            }
        }
    }
    
    static void setGraph() {
        in = new int[k+1];
        graph = new Node[k+1];
        
        for (int[] seq : seqs) {
            int u = seq[0];
            int v = seq[1];
            graph[u] = new Node(v, graph[u]);
            in[v]++;
        }
    }
    
    static int getDist(int u, int v) {
        if (u == v) return 0;
        
        int[] uInfo = panels[u-1];
        int[] vInfo = panels[v-1];
        
        int uY = uInfo[1]-1, uX = uInfo[2]-1, uF = uInfo[0];
        int vY = vInfo[1]-1, vX = vInfo[2]-1, vF = vInfo[0];

        if (uF == vF) {
            return bfs(uY, uX, vY, vX);
        }
        
        return dist[uY][uX] + dist[vY][vX] + Math.abs(uF - vF);
    }
    
    static int bfs(int sy, int sx, int ey, int ex) {
        if (sy == ey && sx == ex) return 0;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx, 0});
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        visited[sy][sx] = true;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            int d = node[2];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && grid[ny].charAt(nx) != '#') {
                    if (ny == ey && nx == ex) {
                        return d + 1;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, d + 1});
                }
            }
        }
        return MAX;
    }
}