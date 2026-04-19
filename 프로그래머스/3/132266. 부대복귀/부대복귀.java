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
    static Node[] graph;
    static final int MAX = 10000000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new Node[n+1];
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            
            graph[u] = new Node(v, graph[u]);
            graph[v] = new Node(u, graph[v]);
        }
        
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(n, roads, sources[i], destination);
        }
        
        return answer;
    }
    
    
    static int bfs(int n, int[][] roads, int source, int destination) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {source, 0});
        
        boolean[] visited = new boolean[n+1];
        visited[source] = true;
        
        while (!q.isEmpty()) { 
            int[] node = q.poll();
            int v = node[0];
            int w = node[1];
            
            if (v == destination) return w;
            
            for (Node next = graph[v]; next != null; next = next.node) {
                int nv = next.v;
                if (!visited[nv]) {
                    visited[nv] = true;
                    q.offer(new int[]{nv, w+1});
                }
            }
        }
        
        return -1;
    }
}