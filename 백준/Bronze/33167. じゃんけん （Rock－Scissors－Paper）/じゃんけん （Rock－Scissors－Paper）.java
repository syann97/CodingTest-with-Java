import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < N; i++) {
            char a = A[i];
            char b = B[i];

            if (a == 'R') {
                if (b == 'S') aCount++;
                else if (b == 'P') bCount++;
            }
            else if (a == 'S') {
                if (b == 'P') aCount++;
                else if (b == 'R') bCount++;
            }
            else {
                if (b == 'R') aCount++;
                else if (b == 'S') bCount++;
            }
        }
        System.out.println(aCount + " " + bCount);
    }
}
