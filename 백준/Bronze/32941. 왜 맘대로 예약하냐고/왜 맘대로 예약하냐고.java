import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        boolean answer = true;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boolean canParticipate = false;

            for (int j = 0; j < A; j++) {
                if (Integer.parseInt(st.nextToken()) == X) {
                    canParticipate = true;
                    break;
                }
            }

            if (!canParticipate) {
                answer = false;
                break;
            }
        }

        System.out.println(answer ? "YES" : "NO");
    }
}
