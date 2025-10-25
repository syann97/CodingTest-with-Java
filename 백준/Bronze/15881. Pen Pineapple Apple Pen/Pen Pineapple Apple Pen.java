import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        for (int i = 0; i < N - 3; i++) {
            String check = s.substring(i, i + 4);
            if (check.equals("pPAp")) {
                count++;
                i += 3;
            }
        }

        System.out.println(count);
    }
}