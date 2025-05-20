import java.io.*;
import java.util.*;

// 개인 학습용 헝가리안 알고리즘
public class Main {
    // 무한대 상수 (비교 시 사용할 큰 값)
    static final int INF = Integer.MAX_VALUE;
    static int N;                      // 사람 수 (또는 일 수)
    static int[][] cost;              // 비용 행렬 (cost[i][j] = i번 사람이 j번 일을 할 때 드는 비용)
    static int[] u, v;                // 잠재값 (u: 행 쪽, v: 열 쪽), 이분 그래프의 라벨
    static int[] p, way;              // p: 매칭된 열(일) 번호, way: 최적 경로 추적용
    static int[] minv;                // 현재 노드에서 가장 최소 비용
    static boolean[] used;           // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1]; // 1-based indexing 사용

        // 비용 행렬 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소 비용 매칭 결과 출력
        System.out.println(hungarian());
    }

    static int hungarian() {
        u = new int[N + 1];  // 행 쪽 라벨
        v = new int[N + 1];  // 열 쪽 라벨
        p = new int[N + 1];  // 매칭된 행 정보
        way = new int[N + 1]; // 최적 경로 추적용

        // 사람 i를 순차적으로 매칭
        for (int i = 1; i <= N; i++) {
            p[0] = i;           // 현재 추가하려는 행 (사람)
            int j0 = 0;         // 시작점 (열 방향)
            minv = new int[N + 1];     // 최소 비용
            used = new boolean[N + 1]; // 방문 여부 초기화
            Arrays.fill(minv, INF);    // 초기값 무한대로 설정

            // 경로 찾기 (최소 경로 확장)
            do {
                used[j0] = true;       // 현재 열 방문 처리
                int i0 = p[j0];        // 현재 매칭된 행
                int delta = INF;       // 가장 작은 비용 차이
                int j1 = 0;            // 다음에 방문할 열

                // 열(일)을 순회하며 최적 매칭 후보 탐색
                for (int j = 1; j <= N; j++) {
                    if (!used[j]) {
                        // 현재 행(i0)에서 열(j)로 가는 비용을 라벨 차이를 고려해 계산
                        int cur = cost[i0][j] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0; // 이전 열 저장
                        }
                        // 최소 비용 갱신
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }

                // 라벨 조정: u, v, minv 업데이트
                for (int j = 0; j <= N; j++) {
                    if (used[j]) {
                        u[p[j]] += delta; // 행 쪽 라벨 증가
                        v[j] -= delta;    // 열 쪽 라벨 감소
                    } else {
                        minv[j] -= delta; // 아직 안 방문한 곳은 남은 비용 감소
                    }
                }

                j0 = j1; // 다음 열로 이동
            } while (p[j0] != 0); // 빈 열(매칭되지 않은 열)을 찾을 때까지 반복

            // Augmenting path (증강 경로) 따라 매칭 갱신
            do {
                int j1 = way[j0];   // 이전 열
                p[j0] = p[j1];      // 이전 열이 가리키던 행을 현재 열로 매칭
                j0 = j1;
            } while (j0 != 0);
        }

        // v[0]에 전체 최소 비용이 -로 저장되어 있음
        return -v[0];
    }
}
