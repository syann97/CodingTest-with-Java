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
	static Node[] start;
	static Node[] end;
	static int N;
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(greedy());
	}

	static int greedy() {
		int s = 0;
		int e = 0;
		int stack = 0;
		int max = 0;;

		while (s < N) {
			if (start[s].v < end[e].v) {
				stack++;
				s++;
				max = Math.max(max, stack);
			}
			else {
				stack--;
				e++;
			}
		}

		return max;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		start = new Node[N];
		end = new Node[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			start[i] = new Node(Integer.parseInt(st.nextToken()), 1);
			end[i] = new Node(Integer.parseInt(st.nextToken()), -1);
		}

		Arrays.sort(start);
		Arrays.sort(end);
	}
}
