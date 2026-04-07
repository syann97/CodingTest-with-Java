import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int v;
	int w;
	Edge edge;

	public Edge (int v, int w, Edge edge) {
		this.v = v;
		this.w = w;
		this.edge = edge;
	}
}

public class Main {
	static StringTokenizer st;
	static Edge[] graph;
	static int N, M;

	public static void main(String[] args) throws Exception {
		init();
		dijkstra();
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new Edge[N+1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u] = new Edge(v, w, graph[u]);
			graph[v] = new Edge(u, w, graph[v]);
		}
	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{1, 0});

		int[] dist = new int[N+1];
		int[] parent = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			int v = edge[0];
			int w = edge[1];

			if (dist[v] < w) continue;

			for (Edge next = graph[v]; next != null; next = next.edge) {
				int nv = next.v;
				int nw = dist[v] + next.w;

				if (dist[nv] > nw) {
					dist[nv] = nw;
					parent[nv] = v;
					pq.offer(new int[]{nv, nw});
				}
			}
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if (parent[i] != 0) {
				sb.append(i).append(" ").append(parent[i]).append("\n");
				count++;
			}
		}

		System.out.println(count);
		System.out.print(sb);
	}
}
