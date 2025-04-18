import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node> {
    int dest;
    int cost;

    public Node(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    // 우선순위 큐에서 비용 기준으로 정렬되도록 compareTo 정의
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] graph_reversed;

    static int X;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N+1];
        graph_reversed = new ArrayList[N+1];


        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graph_reversed[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, c));
            graph_reversed[y].add(new Node(x, c));
        }

        System.out.println(getResult(dijkstra(graph), dijkstra(graph_reversed)));
    }

    static int[] dijkstra (ArrayList<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[X] = 0;

        pq.add(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph[now.dest]) {
                int total_cost = now.cost + next.cost;
                if (total_cost <= visited[next.dest]) {
                    visited[next.dest] = total_cost;
                    pq.add(new Node(next.dest, total_cost));
                }
            }
        }
        return visited;
    }

    static int getResult(int[] a, int[] b) {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, a[i] + b[i]);
        }
        return answer;
    }
}
