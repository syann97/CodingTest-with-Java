import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int v;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        sb.append('\n');
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int cv) {
        sb.append(cv).append(' ');
        visited[cv] = true;

        for (int nv : graph[cv]) {
            if (!visited[nv]) {
                dfs(nv);
            }
        }
    }

    static void bfs(int s) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int cv = q.poll();
            sb.append(cv).append(' ');

            for (int nv : graph[cv]) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    q.add(nv);
                }
            }
        }
    }
}














