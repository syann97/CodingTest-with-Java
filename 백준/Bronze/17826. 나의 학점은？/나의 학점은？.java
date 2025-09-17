import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[50];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 50; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);

        int N = Integer.parseInt(br.readLine());
        int rank = 1;
        for (int i = 49; i >= 0; i--) {
            if (scores[i] == N) break;
            rank++;
        }

        if (rank <= 5) System.out.println("A+");
        else if (rank <= 15) System.out.println("A0");
        else if (rank <= 30) System.out.println("B+");
        else if (rank <= 35) System.out.println("B0");
        else if (rank <= 45) System.out.println("C+");
        else if (rank <= 48) System.out.println("C0");
        else System.out.println("F");
    }
}