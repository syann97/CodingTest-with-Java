import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	static int T;
	static boolean[][][] visited;
	static int[][] castle;
	static StringTokenizer st;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(bfs());
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		visited = new boolean[2][N][M];
		castle = new int[N][M];

		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < M; j++) {
				 castle[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
	}

	static String bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{0, 0, 0});
		visited[0][0][0] = true;


		// 검 먹은 상태
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				int[] node = q.poll();
				int z = node[0];
				int y = node[1];
				int x = node[2];

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (0 <= ny && ny < N && 0 <= nx && nx < M) {
						if (ny == N-1 && nx == M-1) return Integer.toString(time + 1);

						if (z == 1) {
							if (!visited[z][ny][nx]) {
								visited[z][ny][nx] = true;
								q.offer(new int[]{z, ny, nx});
							}
						}
						else if (z == 0) {
							if (castle[ny][nx] == 2 && !visited[1][ny][nx]) {
								visited[1][ny][nx] = true;
								q.offer(new int[]{1, ny, nx});
							}
							else if (castle[ny][nx] == 0 && !visited[0][ny][nx]) {
								visited[0][ny][nx] = true;
								q.offer(new int[]{0, ny, nx});
							}
						}
					}
				}

			}

			if (time == T) return "Fail";
			time++;
		}

		return "Fail";
	}
}
