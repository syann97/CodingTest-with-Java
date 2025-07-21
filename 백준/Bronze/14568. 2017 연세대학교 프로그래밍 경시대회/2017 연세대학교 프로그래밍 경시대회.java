import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1 ; i < N; i++){
            for(int j = 1 ; j < N ; j++){
                for(int k = 1 ; k < N ; k++){
                    if((N - (i + j + k) != 0) || (i % 2 == 1) || (j < k + 2)) continue;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}