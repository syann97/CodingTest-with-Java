import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();

        for (char c : chars) {
            int ascii = c - 3;
            if (c - 3 < 65) ascii = c + 23;
            sb.append((char)ascii);
        }
        System.out.println(sb);
    }
}
