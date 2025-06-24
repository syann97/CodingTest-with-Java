import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        return this.w - o.w;
    }
}

public class Main {
    static PriorityQueue<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new PriorityQueue<>();
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
        }

        int count = V;
        int answer = 0;
        int max = 0;

        while (count > 1) {
            Edge edge = edges.poll();

            if (union(edge.u, edge.v)) {
                max = Math.max(max, edge.w);
                answer += edge.w;
                count--;
            }
        }

        System.out.println(answer - max);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);


        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
