import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // GIST 로고의 각 줄을 문자열 배열로 정의합니다.
        String[] gistLogo = {
                "G...",
                ".I.T",
                "..S."
        };

        for (int i = 0; i < 3; i++) {
            for (int row = 0; row < K; row++) {
                for (int j = 0; j < 4; j++) {
                    char c = gistLogo[i].charAt(j);
                    for (int col = 0; col < K; col++) {
                        sb.append(c);
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}