import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static PriorityQueue<Integer> manPlus;
	static PriorityQueue<Integer> manMinus;
	static PriorityQueue<Integer> womanPlus;
	static PriorityQueue<Integer> womanMinus;
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(greedy());
	}

	private static int greedy() {
		int pair = 0;
		while (!manPlus.isEmpty() && !womanMinus.isEmpty()) {
			int man = manPlus.peek();
			int woman = womanMinus.peek();

			if (man < woman) {
				pair++;
				manPlus.poll();
				womanMinus.poll();
			}
			else {
				womanMinus.poll();
			}
		}

		while (!manMinus.isEmpty() && !womanPlus.isEmpty()) {
			int man = manMinus.peek();
			int woman = womanPlus.peek();

			if (man > woman) {
				pair++;
				manMinus.poll();
				womanPlus.poll();
			}
			else {
				manMinus.poll();
			}
		}

		return pair;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		manPlus = new PriorityQueue<>();
		manMinus = new PriorityQueue<>();
		womanPlus = new PriorityQueue<>();
		womanMinus = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tall = Integer.parseInt(st.nextToken());
			if (tall > 0) {
				manPlus.offer(tall);
			}
			else {
				manMinus.offer(~tall + 1);
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tall = Integer.parseInt(st.nextToken());
			if (tall > 0) {
				womanPlus.offer(tall);
			}
			else {
				womanMinus.offer(~tall + 1);
			}
		}
	}
}
