import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v;
	int w;

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}

public class Main {
	static final int MAX = 2000000000;

	static StringTokenizer st;
	static ArrayList<Edge>[] graph;

	static int[] dist;
	static int[] vis;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(dijkstra());
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) st.nextToken();

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		dist = new int[N + 1];
		vis = new int[N + 1];
		Arrays.fill(dist, MAX);
	}

	static String dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

		dist[1] = 0;
		vis[1] = 1;
		pq.offer(new int[]{1, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int d = cur[1];

			if (dist[v] < d) continue;

			for (Edge next : graph[v]) {
				int nv = next.v;
				int nd = d + next.w;

				if (dist[nv] > nd) {
					dist[nv] = nd;
					vis[nv] = vis[v];
					pq.offer(new int[]{nv, nd});
				}
				else if (dist[nv] == nd) {
					vis[nv] = Math.min(2, vis[nv] + vis[v]);
				}
			}
		}

		return vis[N] >= 2 ? "yes" : "no";
	}
}
