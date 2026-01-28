import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        String answer = "";
        for (int i = 0; i < 15; i++) {
            if (flag) break;

            for (char c : br.readLine().toCharArray()) {
                if (c == 'w' || c == 'b' || c == 'g') {
                    if (c == 'w') answer = "chunbae";
                    else if (c == 'b') answer = "nabi";
                    else if (c == 'g') answer = "yeongcheol";
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
