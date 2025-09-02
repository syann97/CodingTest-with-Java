import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (c == 'J') sb.append('O');
            else if (c == 'O') sb.append('I');
            else sb.append('J');
        }

        System.out.print(sb);
    }
}
