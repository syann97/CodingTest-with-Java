import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
	static int N;
	static int K;
	static StringTokenizer st;
	static int[] arr;
	static int[] c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		c = new int[K];


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(c);

		if (!getAnswer()) {
			System.out.println(-1);
		}
		else {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
		}

		System.out.println(sb);
	}

	static boolean getAnswer() {
		int cIndex = K-1;
		int pIndex = 0;
		arr = new int[N];
		int colorNumber = 1;

		if (c[cIndex] * 2 > N + 1) return false;

		while (cIndex >= 0) {
			int insertCount = c[cIndex];

			while (insertCount-- > 0) {
				arr[pIndex] = colorNumber;
				pIndex += 2;
				if (pIndex >= N) {
					pIndex = 1;
				}
			}

			colorNumber++;
			cIndex--;
		}

		return true;
	}
}
