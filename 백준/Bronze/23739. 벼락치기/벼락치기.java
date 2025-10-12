import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] chapters = new int[N];
        int[] study_time = new int[N];

        for (int i = 0; i < N; i++) {
            chapters[i] = Integer.parseInt(br.readLine());
        }

        int time = 30;
        for (int i = 0; i < N; i++) {
            int cost_time = time - chapters[i];

            // 공부 시간을 모두 소비하기 전에 챕터를 다 소화한 경우
            if (cost_time >= 0) {
                study_time[i] = chapters[i];
                if (cost_time == 0) time = 30;
                else time = cost_time;
            }
            // 공부 시간을 다 소모했는데 소화못한 경우
            else {
                study_time[i] = time;
                time = 30;
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (study_time[i] * 2 >= chapters[i]) answer++;
        }

        System.out.println(answer);
    }
}