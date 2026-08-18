import java.util.*;


class Edge implements Comparable<Edge> {
    int v;
    int w; // intensity
    
    public Edge (int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    // 같은 intensity인 경우 -> 산봉우리 낮은 것 선택
    @Override
    public int compareTo(Edge o) {
        if (this.w == o.w) {
            return Integer.compare(this.v, o.v);
        }
        return Integer.compare(this.w, o.w);
    }
}


class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static boolean[] isSummit;
    static boolean[] isGate;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        init(n, paths, gates, summits);
        
        return dijkstra(n, gates, summits);
    }
    
    static int[] dijkstra(int n, int[] gates, int[] summits) {
        int[] answer = new int[]{MAX, MAX};
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, MAX);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int gate : gates) {
            pq.offer(new Edge(gate, 0));
            intensity[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w; // intensity
            
            if (intensity[v] < w) continue;
            
            for (Edge next : graph[v]) {
                int nv = next.v;
                int nw = Math.max(w, next.w);
                
                if (isGate[nv]) continue;
                
                if (intensity[nv] > nw) {
                    intensity[nv] = nw;
                    
                    if (!isSummit[nv]) pq.offer(new Edge(nv, nw));
                }
            }
        }
        
        for (int index : summits) {
            if (intensity[index] < answer[1] ||
               (intensity[index] == answer[1] && index < answer[0])) {
                answer[0] = index;
                answer[1] = intensity[index];
            }
        }
        
        return answer;
    }
    
    static void init(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n+1];
        isSummit = new boolean[n+1];
        isGate = new boolean[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // paths
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        
        for (int index : gates) {
            isGate[index] = true;
        }
        
        for (int index : summits) {
            isSummit[index] = true;
        }
    }
}