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
    public int solution(int n, int[][] edges) {
        graph = new Node[n+1];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph[u] = new Node(v, graph[u]);
            graph[v] = new Node(u, graph[v]);
        }
           
        return bfs(n);
    }
    
    
    static int bfs(int n) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count = size;
            
            while(size-- > 0) {
                int v = q.poll();
                
                for (Node node = graph[v]; node != null; node = node.node) {
                    int nv = node.v;
                    
                    if (!visited[nv]) {
                        visited[nv] = true;
                        q.offer(nv);
                    }
                }
            }
        }
        
        return count;
    }
}