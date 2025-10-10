import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 3; i <= N - 6; i += 3) {
            for (int j = 3; j <= N - 6; j += 3) {
                if (i + j > N) break;
                for (int k = 3; k <= N - 6; k += 3) {
                    if (i + j + k > N) break;
                    if (i + j + k == N) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}