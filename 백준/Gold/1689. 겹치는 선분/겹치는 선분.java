import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
	int v;
	int w;

	public Node (int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}
}


public class Main {
	static StringTokenizer st;
	static Node[] nodes;
	static int N;
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(greedy());
	}

	static int greedy() {
		int stack = 0;
		int max = 0;
		int before = -1;

		for (Node node : nodes) {
			int v = node.v;
			
			if (v != before) {
				max = Math.max(max, stack);
				before = v;
			}

			stack += node.w;
		}

		return max;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new Node[2 * N];

		for (int i = 0; i < 2 * N; i += 2) {
			st = new StringTokenizer(br.readLine());
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), 1);
			nodes[i+1] = new Node(Integer.parseInt(st.nextToken()), -1);
		}

		Arrays.sort(nodes);
	}
}
