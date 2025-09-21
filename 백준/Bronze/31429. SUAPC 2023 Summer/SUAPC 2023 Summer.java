import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[][] answer = {{0, 0}, {12, 1600}, {11, 894}, {11, 1327}, {10, 1311}, {9, 1004}, {9, 1178}, {9, 1357}, {8, 837}, {7, 1055}, {6, 556}, {6, 773}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(answer[N][0] + " " + answer[N][1]);
    }
}