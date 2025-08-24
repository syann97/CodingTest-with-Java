import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'i') sb.append('I');
            else if (c == 'I') sb.append('i');
            else if (c == 'l') sb.append('L');
            else sb.append('l');
        }

        System.out.println(sb);
    }
}