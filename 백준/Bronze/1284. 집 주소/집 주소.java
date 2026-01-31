import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();

            if (s.equals("0")) break;

            int width = 2 + s.length() - 1;

            for (char c : s.toCharArray()) {
                if (c == '1') width += 2;
                else if (c == '0') width += 4;
                else width += 3;

            }
            sb.append(width).append("\n");
        }

        System.out.println(sb);
    }
}
