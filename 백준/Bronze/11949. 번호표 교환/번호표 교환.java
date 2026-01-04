import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j < N; j++) {
                if (numbers[j] % i > numbers[j+1] % i) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(numbers[i]).append("\n");
        }

        System.out.print(sb);
    }
}
