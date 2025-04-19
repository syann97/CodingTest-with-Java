import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) answer += (int) Math.pow(i, 3);
        System.out.println(answer);
    }
}
