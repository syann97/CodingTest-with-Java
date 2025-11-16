import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i  = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(bubbleSortK(arr, N, K));
    }
    
    
    static String bubbleSortK (int[] arr, int N, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (count == K) break;
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    count++;
                }
            }
        }

        if (count == K) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
        }
        else sb.append("-1");

        return sb.toString();
    }
}