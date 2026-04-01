import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int H;
	static int W;
	static int R;
	static int C;
	static int D;
	static int[][] ruleA;
	static int[][] ruleB;
	static int[][][] visited;
	static boolean[][] dust;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		initDust();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new int[H][W][4];

		ruleA = new int[H][W];
		ruleB = new int[H][W];

		fillArray(ruleA, br);
		fillArray(ruleB, br);
	}

	static void initDust() {
		dust = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(dust[i], true);
		}
	}

	static void fillArray(int[][] rule, BufferedReader br) throws IOException {
		for (int i = 0; i < H; i++) {
			String line = br.readLine().replace(" ", "");
			for (int j = 0; j < W; j++) {
				rule[i][j] = line.charAt(j) - '0';
			}
		}
	}

	static int doCleanAris() {
		int moves = 1;
		int save = 1;
		while (true) {

			if (visited[R][C][D] == save) {
				return save - 1;
			}
			visited[R][C][D] = save;

			boolean isCleaning = false;
			if (dust[R][C]) {
				dust[R][C] = false;
				D = (D + ruleA[R][C]) % 4;
				isCleaning = true;
			} else {
				D = (D + ruleB[R][C]) % 4;
			}

			R += dy[D];
			C += dx[D];

			if (outbound()) {
				return isCleaning ? moves : save - 1;
			}

			moves++;
			if (isCleaning) {
				save = moves;
			}
		}
	}

	static boolean outbound() {
		return R < 0 || R >= H || C < 0 || C >= W;
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(doCleanAris());
	}
}
