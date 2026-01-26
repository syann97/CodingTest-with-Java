import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N - 1; i++) {
            int teamNum = Integer.parseInt(st.nextToken());
            count[teamNum]++;
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}