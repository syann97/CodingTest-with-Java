import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node> {
    int dest;   // 도착 노드
    int cost;   // 비용

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
    // static 변수 정의
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        ArrayList<Node>[] graph_reversed = new ArrayList[N+1];


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

        System.out.println(getAnswer(dijkstra(graph), dijkstra(graph_reversed)));
    }

    static int[] dijkstra (ArrayList<Node>[] graph) {
        // 변수 선언
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] visited = new int[N+1];

        // 변수 초기화
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[X] = 0;
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph[now.dest]) {
                if (visited[next.dest] > visited[now.dest] + next.cost) {
                    visited[next.dest] = visited[now.dest] + next.cost;
                    pq.offer(new Node(next.dest, visited[next.dest]));
                }
            }
        }
        return visited;
    }

    static int getAnswer(int[] a, int[] b) {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, a[i] + b[i]);
        }
        return answer;
    }
}
