import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N;
        while((N = Integer.parseInt(br.readLine())) != 0) {
            int count = N;
            while (count > 0) {
                for (int i = 0; i <= N-count; i++) sb.append("*");
                sb.append("\n");
                count--;
            }
        }
        System.out.print(sb);
    }
}
