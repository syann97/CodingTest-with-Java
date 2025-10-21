import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] teamA = new int[N];
        int[] teamB = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            teamA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            teamB[i] = Integer.parseInt(st.nextToken());
        }

        boolean isBeforeWinnerIsTeamA = rsp(teamA[0], teamB[0]) == 1;
        int streak = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            int a = teamA[i];
            int b = teamB[i];

            if (rsp(a, b) == 0) {
                isBeforeWinnerIsTeamA = !isBeforeWinnerIsTeamA;
                streak = 1;
            }
            else if (rsp(a, b) == 1) {
                if (isBeforeWinnerIsTeamA) streak++;
                else {
                    isBeforeWinnerIsTeamA = true;
                    streak = 1;
                }
            }
            else {
                if (!isBeforeWinnerIsTeamA) streak++;
                else {
                    isBeforeWinnerIsTeamA = false;
                    streak = 1;
                }
            }

            max = Math.max(max, streak);
        }

        System.out.println(max);
    }

    static int rsp (int a, int b) {
        if (a == 1) {
            if (b == 1) return 0;
            else if (b == 2) return -1;
            else return 1;
        }

        else if (a == 2) {
            if (b == 1) return 1;
            else if (b == 2) return 0;
            else return -1;
        }

        else {
            if (b == 1) return -1;
            else if (b == 2) return 1;
            else return 0;
        }
    }
}