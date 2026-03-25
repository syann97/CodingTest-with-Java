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
	static List<Set<Integer>> nearRoomList;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int[][] castleMap;
	static int[][] mapIndex;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		floodFill();

		System.out.println(getRoomCount());
		System.out.println(getMaxArea());
		System.out.println(getBreakOneWallMaxArea());
	}

	private static int getBreakOneWallMaxArea() {
		int max = 0;
		for (int i = 1; i < nearRoomList.size(); i++) {
			int baseArea = roomSpaceList.get(i);
			for (int target : nearRoomList.get(i)) {
				int sumArea = baseArea + roomSpaceList.get(target);
				max = Math.max(max, sumArea);
			}
		}
		return max;
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

	static void bfs(int i, int j, int index) {
		int space = 0;
		nearRoomList.add(new HashSet<>());

		ArrayDeque<Node> q = new ArrayDeque<>();
		q.offer(new Node(i, j));
		mapIndex[i][j] = index;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (inbound(ny, nx) && isNotOtherRoom(ny, nx, index) && isNotWall(ny, nx, d) && isNotVisited(ny, nx)) {
					mapIndex[ny][nx] = index;
					q.offer(new Node(ny, nx));
				}
			}
			space++;
		}

		roomSpaceList.add(space);
	}

	static boolean isNotVisited(int ny, int nx) {
		return mapIndex[ny][nx] == 0;
	}

	static boolean isNotOtherRoom(int ny, int nx, int index) {
		if (mapIndex[ny][nx] != 0 && mapIndex[ny][nx] != index) {
			nearRoomList.get(index).add(mapIndex[ny][nx]);
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
		roomSpaceList = new ArrayList<>();
		nearRoomList = new ArrayList<>();

		roomSpaceList.add(0);
		nearRoomList.add(new HashSet<>());

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
