import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int v;
	long w;

	public Edge(int v, long w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge e) {
		return Long.compare(this.w, e.w);
	}
}

public class Main {
	static StringTokenizer st;
	static int N;
	static int M;
	static boolean[] isVisible;
	static ArrayList<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		isVisible = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			isVisible[i] = tmp == 1;
			graph[i] = new ArrayList<>();
		}
		isVisible[N-1] = false;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		System.out.println(dijkstra());
	}

	static long dijkstra() {
		long[] time = new long[N];
		Arrays.fill(time, Long.MAX_VALUE);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		time[0] = 0;

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.v;
			long w = edge.w;

			if (time[v] < w) continue;

			for (Edge e : graph[v]) {
				int nv = e.v;
				long nw = w + e.w;

				if (isVisible[nv]) continue;

				if (nw < time[nv]) {
					time[nv] = nw;
					pq.offer(new Edge(nv, nw));
				}
			}
		}

		return time[N-1] == Long.MAX_VALUE ? -1 : time[N-1];
	}
}