import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


class Color implements Comparable<Color> {
	int index;
	int count;

	public Color (int index, int count) {
		this.index = index;
		this.count = count;
	}

	@Override
	public int compareTo (Color o) {
		return o.count - this.count;
	}
}

public class Main {
	static int N;
	static int K;
	static StringTokenizer st;
	static int[] arr;
	static Color[] c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		c = new Color[K];

		st = new StringTokenizer(br.readLine());
		int index = 1;
		for (int i = 0; i < K; i++) {
			int count = Integer.parseInt(st.nextToken());
			c[i] = new Color(index, count);
			index++;
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
		if (c[0].count * (long)2 > N + 1) return false;

		int pIndex = 0;
		arr = new int[N];

		for (int i = 0; i < K; i++) {
			int insertCount = c[i].count;
			int insertIndex = c[i].index;

			while (insertCount-- > 0) {
				arr[pIndex] = insertIndex;
				pIndex += 2;
				if (pIndex >= N) {
					pIndex = 1;
				}
			}
		}
		return true;
	}
}
