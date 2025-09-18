import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = 0;
        if (N <= 1) answer = 1;
        else if (N <= 3) answer = 2;
        else if (N <= 6) answer = 3;
        else if (N <= 10) answer = 4;
        else if (N <= 15) answer = 5;
        else if (N <= 21) answer = 6;
        else if (N <= 28) answer = 7;
        else answer = ((N - 29) / 7 + 8);

        System.out.println(answer);
    }
}