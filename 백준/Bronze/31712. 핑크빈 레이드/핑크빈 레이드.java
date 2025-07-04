import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] C = new int[3];
        int[] D = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int HP = Integer.parseInt(br.readLine());

        int time = -1;

        while(HP > 0) {
            time++;
            for (int i = 0; i < 3; i++) {
                if (time % C[i] == 0) HP -= D[i];
            }
        }

        System.out.println(time);
    }
}
