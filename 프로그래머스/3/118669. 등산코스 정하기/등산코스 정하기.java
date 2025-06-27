import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    int w;
    
    public Edge (int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo (Edge o) {
        return Integer.compare(this.w, o.w);
    }
}


class Solution {
    static List<Edge>[] graph;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for (int[] path : paths) {
            graph[path[0]].add(new Edge(path[1], path[2]));
            graph[path[1]].add(new Edge(path[0], path[2]));
        }
        
        
        return dijkstra(n, gates, summits);
    }
    
    static int[] dijkstra (int n, int[] gates, int[] summits) {
        Arrays.sort(summits);
        Set<Integer> summitSet = new HashSet<>();
        
        for (int summit : summits) {
            summitSet.add(summit);
        }
        
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for (int i = 0; i < gates.length; i++) {
            pq.offer(new Edge(gates[i], 0));
            intensity[gates[i]] = 0;
        }
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w;
            
            if (intensity[v] < w) continue;
            
            for (Edge next : graph[v]) {
                int nv = next.v;
                int nw = Math.max(w, next.w);
                
                if (intensity[nv] > nw) {
                    intensity[nv] = nw;
                    if (!summitSet.contains(nv)) {
                        pq.offer(new Edge(nv, nw));
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (intensity[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = intensity[summit];
            }    
        }
        return answer;
    }

}