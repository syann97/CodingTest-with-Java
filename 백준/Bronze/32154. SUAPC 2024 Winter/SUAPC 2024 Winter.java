import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] records =
            {
                    {},
                    {true, true, true, true, true, true, true, true, false, true, false, true, true},
                    {true, false, true, false, true, true, true, true, true, false, false, true, true},
                    {true, false, true, false, true, true, true, true, true, false, false, true, true},
                    {true, true, true, false, true, true, true, true, false, false, false, true, true},
                    {true, false, true, false, true, true, true, true, false, false, false, true, true},
                    {true, false, true, false, true, true, true, true, false, false, false, true, true},
                    {true, false, true, false, true, true, true, true, false, false, false, true, true},
                    {true, false, true, false, true, true, true, true, false, false, false, true, true},
                    {true, false, true, false, true, true, true, true, false, false, false, true, true},
                    {true, true, true, false, false, true, true, true, false, false, false, true, true}
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (records[N][i]) {
                count++;
                sb.append((char)(i + 65)).append(" ");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
