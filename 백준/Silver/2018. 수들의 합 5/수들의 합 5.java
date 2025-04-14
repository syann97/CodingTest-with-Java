import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int s = 1;
        int e = 1;
        int num = 1;
        int count = 1;

        while (e < N) {
            if (num <= N) {
                if (num == N) {
                    count++;
                }
                e++;
                num += e;
            } else {
                num -= s;
                s++;
            }
        }
        System.out.println(count);
    }
}