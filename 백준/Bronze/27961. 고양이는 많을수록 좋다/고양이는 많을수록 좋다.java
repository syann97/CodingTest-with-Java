import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int answer = 1;
        if (N == 0) {
            answer = 0;
        }
        else {
            long cats = 1;
            while (cats < N) {
                cats *= 2;
                answer++;
            }
        }
        System.out.println(answer);
    }
}