import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    static int[] parents;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        if (P == 0) System.out.println(M);
        else {
            ArrayList<Integer>[] partyList = new ArrayList[M];
            for (int i = 0; i < M; i++) partyList[i] = new ArrayList<>();

            parents = new int[N+1];
            size = new int[N+1];
            Arrays.fill(size, 1);
            for (int i = 1; i <= N; i++) parents[i] = i;

            while (P--> 0) {
                union(0, Integer.parseInt(st.nextToken()));
            }


            for (int party = 0; party < M; party++) {
                st = new StringTokenizer(br.readLine());
                P = Integer.parseInt(st.nextToken());

                int representative = Integer.parseInt(st.nextToken());
                partyList[party].add(representative);

                for (int i = 1; i < P; i++) {
                    int personNumber = Integer.parseInt(st.nextToken());
                    partyList[party].add(personNumber);
                    union(representative, personNumber);
                }
            }

            int answer = 0;
            int trueRoot = find(0);
            for (int party = 0; party < M; party++) {
                boolean isPossibleToLie = true;
                for (int person : partyList[party]) {
                    if (find(person) == trueRoot) {
                        isPossibleToLie = false;
                        break;
                    }
                }
                if (isPossibleToLie) answer++;
            }

            System.out.println(answer);
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union (int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) return;

        if (size[a] < size[b]) {
            parents[a] = b;
            size[b] += size[a];
        }
        else {
            parents[b] = a;
            size[a] += size[b];
        }
    }
}