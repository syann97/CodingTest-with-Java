import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node {
	int y;
	int x;
	public Node (int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> roomSpaceList;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int[][] castleMap;
	static int[][] mapIndex;
	static int M;
	static int N;
	static int breakOneWallMaxArea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		floodFill();

		System.out.println(getRoomCount());
		System.out.println(getMaxArea());
		System.out.println(breakOneWallMaxArea);
	}

	private static int getMaxArea() {
		int max = 0;
		for (int i = 1; i < roomSpaceList.size(); i++) {
			max = Math.max(max, roomSpaceList.get(i));
		}
		return max;
	}

	static int getRoomCount() {
		return roomSpaceList.size() - 1;
	}

	static void floodFill() {
		int index = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapIndex[i][j] == 0) {
					bfs(i, j, index);
					index++;
				}
			}
		}
	}

	static void bfs(int sy, int sx, int index) {
		int space = 0;
		boolean[] visitedOtherRoom = new boolean[index];

		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(new Node(sy, sx));
		mapIndex[sy][sx] = index;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (inbound(ny, nx) && isNotOtherRoom(index, mapIndex[ny][nx], visitedOtherRoom) && isNotWall(ny, nx, d) && isNotVisited(ny, nx)) {
					mapIndex[ny][nx] = index;
					q.offer(new Node(ny, nx));
				}
			}
			space++;
		}

		for (int i = 1; i < index; i++) {
			if (visitedOtherRoom[i]) {
				breakOneWallMaxArea = Math.max(breakOneWallMaxArea, space + roomSpaceList.get(i));
			}
		}

		roomSpaceList.add(space);
	}

	static boolean isNotVisited(int ny, int nx) {
		return mapIndex[ny][nx] == 0;
	}

	static boolean isNotOtherRoom(int index, int other, boolean[] visited) {
		if (index == other) return true;
		if (visited[other]) return false;
		if (other != 0) {
			visited[other] = true;
			return false;
		}
		return true;
	}

	private static boolean isNotWall(int ny, int nx, int d) {
		return (castleMap[ny][nx] & (1 << d)) == 0;
	}

	static boolean inbound(int ny, int nx) {
		return 0 <= ny && ny < N && 0 <= nx && nx < M;
	}

	static void init() throws IOException {
		breakOneWallMaxArea = 0;
		roomSpaceList = new ArrayList<>();
		roomSpaceList.add(0);

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		castleMap = new int[N][M];
		mapIndex = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				castleMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
