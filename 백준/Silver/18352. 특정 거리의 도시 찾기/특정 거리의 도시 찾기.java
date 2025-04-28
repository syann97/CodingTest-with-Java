import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Node {
    int v;
    int c;

    public Node(int v, int c) {
        this.v = v;
        this.c = c;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 도시 개수
        int M = Integer.parseInt(st.nextToken());   // 도로 개수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시 번호

        ArrayDeque<Integer>[] graph = new ArrayDeque[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        boolean[] visited = new boolean[N+1];
        System.out.println(bfs(graph, visited, K, X));
    }

    static String bfs(ArrayDeque<Integer>[] graph, boolean[] visited, int K, int X) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(new Node(X, 0));
        visited[X] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.c == K) {
                list.add(node.v);
                continue;
            }

            for (int nv : graph[node.v]) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    q.offer(new Node(nv, node.c + 1));
                }
            }
        }
        
        if (list.isEmpty()) return "-1";
        else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(list);
            for (int v : list) {
                sb.append(v).append("\n");
            }
            return sb.toString();
        }

    }
}