import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Quest {
    int STR;
    int INT;
    int POINT;

    public Quest(int STR, int INT, int POINT) {
        this.STR = STR;
        this.INT = INT;
        this.POINT = POINT;
    }
}

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 현재 스탯이 가능한지 여부
        boolean[][] isPossible = new boolean[1001][1001];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                isPossible[i][j] = true;
            }
        }

        // 남은 포인트
        int[][] remain = new int[1001][1001];

        // 클리어 가능 퀘스트 수
        int[][] clear = new int[1001][1001];

        // 퀘스트 항목
        Quest[] quests = new Quest[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int STR = Integer.parseInt(st.nextToken());
            int INT = Integer.parseInt(st.nextToken());
            int POINT = Integer.parseInt(st.nextToken());
            quests[i] = new Quest(STR, INT, POINT);
        }

        int max = 0;
        for (int STR = 1; STR <= 1000; STR++) {
            for (int INT = 1; INT <= 1000; INT++) {
                // STR과 INT가 현재 스탯일 경우 클리어 할 수 있는 퀘스트 수와 포인트를 미리 계산
                int rewardPoint = 0;
                for (Quest quest : quests) {
                    if (quest.STR <= STR || quest.INT <= INT) {
                        rewardPoint += quest.POINT;
                        clear[STR][INT]++;
                    }
                }

                // 기본 스탯 1 / 1 고려해서 얻는 포인트와 가능한 스탯인지 계산하는 것이 필요
                int remainPoint = rewardPoint - ((STR - 1) + (INT - 1));


                // 주의 : 보상을 땡겨와서 쓰지 말자
                if (isPossible[STR-1][INT] && remain[STR-1][INT] > 0) {
                    isPossible[STR][INT] = true;
                }

                if (isPossible[STR][INT-1] && remain[STR][INT-1] > 0) {
                    isPossible[STR][INT] = true;
                }

                if (isPossible[STR][INT]) max = Math.max(max, clear[STR][INT]);
                remain[STR][INT] = remainPoint;
            }
        }
        System.out.println(max);
    }
}
