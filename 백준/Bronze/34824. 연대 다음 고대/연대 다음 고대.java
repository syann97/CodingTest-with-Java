import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.equals("yonsei")) {
                System.out.println("Yonsei Won!");
                break;
            }
            else if (s.equals("korea")) {
                System.out.println("Yonsei Lost...");
                break;
            }
        }
    }
}
