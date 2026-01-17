import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	int y;
	int x;

	public Node (int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {-1, 0, 1, 0};
	static int N;
	static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1")) {
					board[i][j] = true;
				}
			}
		}

		int count = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j]) {
					max = Math.max(max, bfs(i, j, board));
					count++;
				}
			}
		}

		System.out.println(count);
		System.out.println(max);
    }

	private static int bfs(int i, int j, boolean[][] board) {
		int count = 0;

		Deque<Node> q = new ArrayDeque<>();
		q.offer(new Node(i, j));
		board[i][j] = false;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;

			count++;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (0 <= ny && ny < N && 0 <= nx && nx < M && board[ny][nx]) {
					board[ny][nx] = false;
					q.offer(new Node(ny, nx));
				}
			}
		}

		return count;
	}
}
