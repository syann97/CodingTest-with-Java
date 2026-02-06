class Solution {
    static int L;
    static int N;
    static int M;
    static int[][] info;
    static int[][] count;
    static int answer = 121;
    public int solution(int[][] info, int n, int m) {
        count = new int[n][m];
        L = info.length;
        N = n;
        M = m;
        this.info = info;
        
        // info에는 i개 물건 훔칠 때 흔적을 남기는데
        // A는 [i][0] B는 [i][1]
        // 흔적은 1 ~ 3개
        // A는 흔적 누적 n개 B는 흔적 누적 m개가 되지 않도록 최적화하되
        // n이 최소가 되도록 답을 구하고
        // 못구하면 -1
        
        // 조건 1 (최대한 둘 다 누적 수 제한 넘지 않는 경우의 수 찾기)
        // 조건 2 그 중 n이 최소가 되는 값 찾기
        // 조건 2-1. 만약 못찾으면 -1
        
        // 브루트 포스 최대 n^40 => 불가능
        // n과 m으로 최적화? 가능할듯
        
        bf(0, 0, 0, 0);
              
        return answer == 121 ? -1 : answer;
    }
    
    static void bf (int idx, int a, int b, int tmp) {
        if (idx == L) {
            if (a < N && b < M) {
                answer = Math.min(answer, tmp);
            }
            return;
        }
        
        boolean flagA = false;
        boolean flagB = false;
        
        int na = a + info[idx][0];
        int nb = b + info[idx][1];
        
        if (na < N) {
            for (int i = 0; i < na; i++) {
                if (count[i][b] >= idx + 1) {
                    flagA = true;
                    break;
                }
            }
        }
        else {
            flagA = true;
        }
        
        if (nb < M) {
            for (int i = 0; i < nb; i++) {
                if (count[a][i] >= idx + 1) {
                    flagB = true;
                    break;
                }
            }
        }
        else {
            flagB = true;
        }
        
        if (!flagA) {
            count[na][b] = idx + 1;
            bf(idx + 1, na, b, na);
        }
        
        if (!flagB) {
            count[a][nb] = idx + 1;
            bf(idx + 1, a, nb, a);
        }
    }
}