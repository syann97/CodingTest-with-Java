import java.util.*;

class Edge implements Comparable<Edge>{
    int v;
    int w;
    
    public Edge (int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

class Node {
    int v;
    int w;
    Node node;
    
    public Node (int v, int w, Node node) {
        this.v = v;
        this.w = w;
        this.node = node;
    }
}

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static Node[] graph;
    static int sa;
    static int sb;
    static int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        graph = new Node[n+1];
        
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            
            graph[u] = new Node(v, w, graph[u]);
            graph[v] = new Node(u, w, graph[v]);
        }
        
        int[] sDist = dijkstra(s);
        int[] aDist = dijkstra(a);
        int[] bDist = dijkstra(b);
        int answer = MAX;
        
        for (int v = 1; v <= n; v++) {
            answer = Math.min(answer, sDist[v] + aDist[v] + bDist[v]);
        }
        
        
        return answer;
    }
    
    
    static int[] dijkstra(int s) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[s] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w;
            
            if (dist[v] < w) continue;
            
            for (Node node = graph[v]; node != null; node = node.node) {
                int nv = node.v;
                int nw = w + node.w;
                
                if (dist[nv] > nw) {
                    dist[nv] = nw;
                    pq.offer(new Edge(nv, nw));
                }
            }
        }
        
        return dist;
    }
}