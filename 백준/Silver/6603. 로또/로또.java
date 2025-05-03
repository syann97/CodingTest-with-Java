import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int[] lottoNumbers = new int[N];

            for (int i = 0; i < N; i++) {
                lottoNumbers[i] = Integer.parseInt(st.nextToken());
            }

            bt(0, 0, new int[6], lottoNumbers);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bt(int idx, int count, int[] selected, int[] lottoNumbers) {
        if (count == 6) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (lottoNumbers.length - idx < 6 - count) return;

        selected[count] = lottoNumbers[idx];
        bt(idx + 1, count + 1, selected, lottoNumbers);
        bt(idx + 1, count, selected, lottoNumbers);
    }
}
