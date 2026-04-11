import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

		PriorityQueue<Integer> compPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			pq.offer(new int[]{d, p});
			max = Math.max(max, d);
		}

		int day = max;
		int answer = 0;

		while (day > 0) {

			while (!pq.isEmpty() && pq.peek()[0] >= day) {
				compPq.offer(pq.poll()[1]);
			}

			if (!compPq.isEmpty()) answer += compPq.poll();

			day--;
		}

		System.out.println(answer);
	}
}
