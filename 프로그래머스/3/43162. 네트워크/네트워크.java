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
    public int solution(int n, int[][] computers) {
        init (n, computers);
        return floodFill(n, computers);
    }
    
    static void dfs (int v, boolean[] visited) {
        for (Node node = graph[v]; node != null; node = node.node) {
            int nv = node.v;
            if (!visited[nv]) {
                visited[nv] = true;
                dfs(nv, visited);
            }
        }
    }
    
    static int floodFill(int n, int[][] computers) {
        int network = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited);
                network++;
            }
        }
        
        return network;
    }
    
    static void init(int n, int[][] computers) {
        graph = new Node[n];
        
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph[i] = new Node(j, graph[i]);
                    graph[j] = new Node(i, graph[j]);
                }
            }
        }
    }
}