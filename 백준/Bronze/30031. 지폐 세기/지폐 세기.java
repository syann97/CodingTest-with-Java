import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.equals("136 68")) answer += 1000;
            else if (s.equals("142 68")) answer += 5000;
            else if (s.equals("148 68")) answer += 10000;
            else answer += 50000;
        }

        System.out.println(answer);
    }
}