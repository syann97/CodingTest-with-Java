import java.util.*;

class Node {
    int y;
    int x;
    
    public Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Edge {
    int v;
    Edge edge;
    
    public Edge (int v, Edge edge) {
        this.v = v;
        this.edge = edge;
    }
}


class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static ArrayList<Integer> startNode;
    static Edge[] graph;
    static int[][] dist;
    static int[][] panels;
    static int[][] seqs;
    static int[][] dp;
    static String[] grid;
    static int[][] panelDist;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[] in;
    static int answer;
    static int R;
    static int C;
    static int L;
    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        init(h, grid, panels, seqs);
        
        
        dp = new int[1<<L][L];
        for (int i = 0; i < (1<<L); i++) {
            Arrays.fill(dp[i], MAX);
        }
        
        for (int node : startNode) {
            int distance = 0;
            
            if (node != 0) distance = panelDist[0][node];
            
            dfs(1, node, distance, 1<<node);
        }
        
        return answer;
    }
    
    static void init(int h, String[] g, int[][] p, int[][] s) {
        answer = MAX;
        R = g.length;
        C = g[0].length();
        
        grid = g;
        panels = p;
        seqs = s;
        
        dist = new int[R][C];
        setElevatorDistance();
        
        L = panels.length;
        setAdjGraph();
        setPanelDist();
    }
    
    static void setElevatorDistance() {
        Node elevatorPos = getElevatorPos();
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        dist[elevatorPos.y][elevatorPos.x] = 1;
        
        for (int d = 0; d < 4; d++) {
            int ny = elevatorPos.y + dy[d];
            int nx = elevatorPos.x + dx[d];
            
            if (ny < 0 || ny >= R || nx < 0 || nx >= C || grid[ny].charAt(nx) == '#') continue;
            
            q.offer(new Node(ny, nx));
            dist[ny][nx] = 1;
        }
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C || dist[ny][nx] > 0 || grid[ny].charAt(nx) == '#') continue;
                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new Node(ny, nx));
            }
        }
        
        dist[elevatorPos.y][elevatorPos.x] = 0;
    }
    
    static Node getElevatorPos() {
        for (int i = 0; i < R; i++) {
            String s = grid[i];
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '@') {
                    return new Node(i, j);
                }               
            }
        }
        return null;
    }
    
    static void print(int[][] arr) {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
    
    static void setAdjGraph() {
        graph = new Edge[L];
        in = new int[L];
        startNode = new ArrayList<>();
        
        for (int[] seq : seqs) {
            int u = seq[0] - 1;
            int v = seq[1] - 1;
            in[v]++;
            graph[u] = new Edge(v, graph[u]);
        }
        
        for (int i = 0; i < L; i++) {
            if (in[i] == 0) {
                startNode.add(i);
            }
        }
    }
    
    static void setPanelDist() {
        panelDist = new int[L][L];
        
        for (int i = 0; i < L; i++) {
            for (int j = i+1; j < L; j++) {
                panelDist[i][j] = calDist(panels[i], panels[j]);
                panelDist[j][i] = panelDist[i][j];
            }
        }
    }
    
    static int calDist(int[] u, int[] v) {
        if (u[0] == v[0]) return bfs(u, v);
        return Math.abs(u[0] - v[0]) + dist[u[1]-1][u[2]-1] + dist[v[1]-1][v[2]-1];
    }
    
    static int bfs(int[] u, int[] v) {
        int sy = u[1] - 1;
        int sx = u[2] - 1;
        int ey = v[1] - 1;
        int ex = v[2] - 1;
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(sy, sx));
        
        boolean[][] visited = new boolean[R][C];
        visited[sy][sx] = true;
        
        int distance = 0;
        while (true) {
            int size = q.size();
            
            while (size-- > 0) {
                Node node = q.poll();
                int y = node.y;
                int x = node.x;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    
                    if (ny == ey && nx == ex) return distance + 1;

                    if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx] || grid[ny].charAt(nx) == '#') continue;
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                }
            }
            
            distance++;
        }
    }
    
    static void dfs(int index, int v, int distance, int status) {
        if (index == L) {
            answer = Math.min(answer, distance);
            return;
        }
        
        if (dp[status][v] <= distance) return;
        dp[status][v] = distance;
        
        for (Edge edge = graph[v]; edge != null; edge = edge.edge) {
            in[edge.v]--;
        }
        
        for (int nv = 0; nv < L; nv++) {
            if (in[nv] == 0 && (status & (1 << nv)) == 0) {
                dfs(index + 1, nv, distance + panelDist[v][nv], (status | (1 << nv)));    
            }
        }
        
        for (Edge edge = graph[v]; edge != null; edge = edge.edge) {
            in[edge.v]++;
        }
    }
}