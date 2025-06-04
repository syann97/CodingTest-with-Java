import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int M = 0;
        int W = 0;
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if (c == 'W') W++;
            else M++;

            if (Math.abs(W - M) > N) {
                if (i + 1 == s.length() || c == s.charAt(i+1)) {
                    break;
                }
            }
            i++;
        }
        System.out.println(i);
    }
}

