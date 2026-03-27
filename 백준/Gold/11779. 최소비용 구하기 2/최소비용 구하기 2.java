import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Edge implements Comparable<Edge> {
	int v;
	long w;

	public Edge (int v, long w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.w, o.w);
	}
}


public class Main {
	static ArrayList<Edge>[] graph;
	static StringTokenizer st;
	static final long LONG_MAX = Long.MAX_VALUE;
	static final int INT_MAX = Integer.MAX_VALUE;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dijkstra(s, e);
	}


	static void dijkstra(int s, int e) {
		long[] dist = new long[N+1];
		int[] trace = new int[N+1];

		Arrays.fill(dist, LONG_MAX);
		dist[s] = 0;
		trace[s] = s;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(s, 0));

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.v;
			long w = edge.w;

			if (v == e) break;
			if (dist[v] < w) continue;

			for (Edge next : graph[v]) {
				int nv = next.v;
				long nw = w + next.w;

				if (nw < dist[nv]) {
					dist[nv] = nw;
					trace[nv] = v;
					pq.offer(new Edge(nv, nw));
				}
			}
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int cv = trace[e];
		stack.push(e);

		while (cv != trace[cv]) {
			stack.push(cv);
			cv = trace[cv];
		}

		if (stack.peek() != cv) stack.push(cv);

		StringBuilder sb = new StringBuilder();
		sb.append(dist[e]).append("\n").append(stack.size()).append("\n");

		while(!stack.isEmpty()) {
			sb.append(stack.poll()).append(" ");
		}

		System.out.println(sb);
	}
}