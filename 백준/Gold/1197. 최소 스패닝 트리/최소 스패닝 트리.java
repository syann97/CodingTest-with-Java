import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int cost;

    public Edge (int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}


public class Main {
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.add(new Edge(A, B, C));
        }

        Collections.sort(edges);

        int total = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                total += edge.cost;
                count++;
            }
            if (count == V - 1) break;
        }

        System.out.println(total);
    }

    // 합치기
    static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) parent[a] = b;
        else parent[b] = a;
    }


    // 최상위 부모 찾기
    static int find (int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }
}