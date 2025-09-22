import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int current = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            char op = br.readLine().charAt(0);
            int num = Integer.parseInt(br.readLine());
            if (op == '+') current += num;
            else current -= num;
        }
        System.out.println(current);
    }
}