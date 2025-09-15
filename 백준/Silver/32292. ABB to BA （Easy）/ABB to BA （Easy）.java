import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            br.readLine();
            String s = br.readLine();
            String tmp = s;

            while (true) {
                tmp = tmp.replace("ABB", "BA");
                if (s.equals(tmp)) break;
                s = tmp;
            }
            System.out.println(s);
        }
    }
}