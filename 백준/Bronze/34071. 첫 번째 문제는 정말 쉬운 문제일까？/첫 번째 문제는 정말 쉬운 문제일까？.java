import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int easy = 1000;
        int hard = 1;

        int firstProblem = Integer.parseInt(br.readLine());
        easy = Math.min(easy, firstProblem);
        hard = Math.max(hard, firstProblem);

        for (int i = 0; i < N - 1; i++) {
            int problem = Integer.parseInt(br.readLine());
            easy = Math.min(easy, problem);
            hard = Math.max(hard, problem);
        }

        System.out.println(easy == firstProblem ? "ez" : hard == firstProblem ? "hard" : "?");
    }
}