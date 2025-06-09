import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] changes = {25, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int C = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                sb.append(C / changes[i]).append(" ");
                C %= changes[i];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}