import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] stations = br.readLine().split(" ");

        int index = 0;

        boolean flag = false;
        while (index < stations.length) {
            if (stations[index].charAt(0) == '(') {
                flag = true;
                break;
            }

            sb.append(stations[index]).append(" ");
            index++;
        }

        sb.append("\n");

        if (!flag) sb.append("-");
        else {
            if (stations[index].charAt(stations[index].length() - 1) == ')') {
                sb.append(stations[index].substring(1, stations[index].length() - 1)).append(" ");
            }
            else {
                sb.append(stations[index].substring(1)).append(" ");

                for (int i = index + 1; i < stations.length - 1; i++) {
                    sb.append(stations[i]).append(" ");
                }
                String lastString = stations[stations.length - 1];
                sb.append(lastString.substring(0, lastString.length() - 1));
            }
        }
        System.out.println(sb);
    }
}