import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken()) % 30;
        int s2 = Integer.parseInt(st.nextToken());

        System.out.println(s1 * 12 == s2 ? "O" : "X");
    }
}
