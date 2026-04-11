import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static StringTokenizer st;
	static PriorityQueue<int[]> pq;
	static PriorityQueue<Integer> compPq;
	static int max;

	public static void main(String[] args) throws Exception {
		init();
		greedy();
	}

	static void greedy() {
		int day = max;
		int answer = 0;
		boolean flag = false;

		while (day > 0) {

			if (!flag) {
				while (true) {
					if (pq.isEmpty()) {
						flag = true;
						break;
					}
					if (pq.peek()[0] < day) break;
					compPq.offer(pq.poll()[1]);
				}
			}
			else {
				if (day >= compPq.size()) {
					while (!compPq.isEmpty()) {
						answer += compPq.poll();
					}
					break;
				}
			}

			if (!compPq.isEmpty()) answer += compPq.poll();

			day--;
		}

		System.out.println(answer);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o2[0] - o1[0];
		});

		compPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			pq.offer(new int[]{d, p});
			max = Math.max(max, d);
		}
	}
}
