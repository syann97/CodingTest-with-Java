import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int price;
        while ((price = Integer.parseInt(br.readLine())) != -1) {
            answer += price;
        }
        System.out.println(answer);
    }
}