import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < c.length - 3; i++) {
            if (c[i] == 'D') {
                if (c[i+1] == 'K' && c[i+2] == 'S' && c[i+3] == 'H') {
                    count++;
                    i += 3;
                }
            }
        }

        System.out.println(count);
    }
}
