import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Wood implements Comparable<Wood> {
    int x;
    int y;
    int z;

    public Wood (int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Wood w) {
        return Integer.compare(this.z, w.z);
    }
}

public class Main {
    static StringTokenizer st;
    static Deque<Wood> diedWood;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주의 (1, 1)부터 시작
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][N];
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Wood> woodList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            // 주의 (x, y)
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // (x, y)의 나무 나이 z
            woodList.add(new Wood(x-1, y-1, z));
        }

        Collections.sort(woodList);

        diedWood = new ArrayDeque<>();
        ArrayDeque<Wood> woods = new ArrayDeque<>();

        woods.addAll(woodList);
        woodList = null;

        while(K-- > 0) {
            spring(area, woods);
            summer(area);
            fall(woods, N);
            winter(A, area, N);
        }

        System.out.println(woods.size());
    }

    // 겨울: 로봇이 돌아다니며 양분 추가, A[r][c] 만큼씩
    static void winter(int[][] A, int[][] area, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] += A[i][j];
            }
        }
    }

    // 가을: 나무 번식 (5의 배수) -> 인접 8칸 나이1 나무 생성
    // *주의* 같은 위치에 여러 나무 가능
    static void fall(ArrayDeque<Wood> woods, int N) {
        ArrayDeque<Wood> tmp = new ArrayDeque<>();
        for (Wood wood : woods) {
            if (wood.z % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = wood.x + dx[d];
                    int ny = wood.y + dy[d];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        tmp.add(new Wood(nx, ny, 1));
                    }
                }
            }
        }

        for (Wood wood : tmp) {
            woods.addFirst(wood);
        }
    }

    // 여름: 봄에 죽은 나무가 양분으로 변환 (나이 / 2, 소수점 X) (v)
    static void summer(int[][] area) {
        while (!diedWood.isEmpty()) {
            Wood wood = diedWood.poll();
            area[wood.x][wood.y] += wood.z / 2;
        }
    }


    // 봄: 나무는 자신의 나이만큼 양분 먹고(v), 나이 1 증가(v)
    // *주의* : 하나의 칸에 여러 개의 나무가 존재시 어린 나무부터 양분을 먹음(v)
    // *주의* : 죽은나무는 여름에 사용되어야 함
    static void spring(int[][] area, Deque<Wood> woods) {
        int size = woods.size();
        while (size-- > 0) {
            Wood wood = woods.pollFirst();

            if (area[wood.x][wood.y] >= wood.z) {
                area[wood.x][wood.y] -= wood.z;
                wood.z++;
                woods.offerLast(wood);
            }
            else {
                diedWood.offerLast(wood);
            }
        }
    }
}