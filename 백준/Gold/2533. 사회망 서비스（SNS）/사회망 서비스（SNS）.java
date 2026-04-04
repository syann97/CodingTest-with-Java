import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int v;
	Node node;

	public Node (int v, Node node) {
		this.v = v;
		this.node = node;
	}
}

public class Main {
	static StringTokenizer st;
	static boolean[] visited;
	static Node[] graph;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws IOException {
		init();
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int v) {
		visited[v] = true;

		dp[v][0] = 0;
		dp[v][1] = 1;

		for (Node node = graph[v]; node != null; node = node.node) {
			int nv = node.v;
			if (!visited[nv]) {
				dfs(nv);
				dp[v][0] += dp[nv][1];
				dp[v][1] += Math.min(dp[nv][0], dp[nv][1]);
			}
		}
	}


	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		graph = new Node[N+1];
		visited = new boolean[N+1];

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u] = new Node(v, graph[u]);
			graph[v] = new Node(u, graph[v]);
		}
	}
}
