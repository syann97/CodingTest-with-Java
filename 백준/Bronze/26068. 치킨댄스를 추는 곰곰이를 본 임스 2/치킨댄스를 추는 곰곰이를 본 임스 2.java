import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = s.replaceAll("D-", "");
            if (Integer.parseInt(s) <= 90) answer++;
        }

        System.out.println(answer);
    }
}