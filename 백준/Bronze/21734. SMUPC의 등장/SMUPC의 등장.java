import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for (char c : s.toCharArray()) {
            int count = calPrintCount(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static int calPrintCount(int code) {
        int count = 0;
        while (code > 0) {
            count += code % 10;
            code /= 10;
        }
        return count;
    }
}

