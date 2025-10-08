import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N * 5; i++) {
            if (i < N) sb.append("@".repeat(N * 5));
            else sb.append("@".repeat(N));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}