import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node {
    int end;
    int time;

    public Node(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int TC;
    static int N;
    static int M;
    static int W;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());
        int S;
        int E;
        int T;

        while (TC --> 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N+1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                graph[S].add(new Node(E, T));
                graph[E].add(new Node(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                graph[S].add(new Node(E, -T));
            }

            System.out.println(hasNegativeCycle());
        }
    }
    static boolean BellmanFord() {
        int[] cost = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j <= N; j++) {
                if (cost[j] == Integer.MAX_VALUE) continue;
                for (Node node : graph[j]) {
                    cost[node.end] = Math.min(cost[node.end], cost[j] + node.time);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (cost[i] == Integer.MAX_VALUE) continue;
            for (Node node : graph[i]) {
                if (cost[node.end] > cost[i] + node.time) return true;
            }
        }
        return false;
    }

    static String hasNegativeCycle() {
        return BellmanFord() ? "YES" : "NO";
    }
}