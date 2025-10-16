import java.util.*;

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;
    
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
    @Override
    public int compareTo(Edge o) {
        if (this.w == o.w) {
            if (this.v == o.v) {
                return Integer.compare(this.u, o.u);
            }
            return Integer.compare(this.v, o.v);
        }
        return Integer.compare(this.w, o.w);
    }
}


class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        TreeSet<Edge> set = new TreeSet<>();
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            set.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        int count = n-1;
        
        while (count > 0 && !set.isEmpty()) {
            Edge edge = set.pollFirst();
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            
            if (!union(u, v)) continue;
            
            answer += edge.w;
            count--;
        }
        
        return count == 0 ? answer : -1;
    }
    
    static int find (int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static boolean union (int x, int y) {
        int a = find(x);
        int b = find(y);
        
        if (a == b) return false;
        parent[a] = b;
        return true;
    }
}