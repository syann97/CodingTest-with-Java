import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int[] start;
	static int[] end;
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
			if (start[s] < end[e]) {
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
		start = new int[N];
		end = new int[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(start);
		Arrays.sort(end);
	}
}
