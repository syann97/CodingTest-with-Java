class Solution {
    static final int MOD = 1000000007;

    public int solution(int n) {
        int totalCells = n * 3;
        int[][] dp = new int[2][1 << 7];
        
        dp[0][0] = 1;
        
        int before = 0;
        int current = 1;
        int inbound = totalCells;

        for (int index = 0; index < inbound; index++) {
            // current 배열 초기화
            for (int i = 0; i < (1 << 7); i++) dp[current][i] = 0;

            for (int state = 0; state < (1 << 7); state++) {
                if (dp[before][state] == 0) continue;

                if ((state & 1) != 0) {
                    int nextState = state >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                    continue;
                }

                // 1. 역 ㄴ (왼쪽으로 튀어나오는 _| 모양) -> c가 0보다 커야 함
                int check = (1 << 0) | (1 << 2) | (1 << 3);
                if (index + 3 < inbound && index % 3 > 0 && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }

                // 2. 가로 ㅡ (1x3) -> 무조건 c=0 에서 시작해야 함
                check = (1 << 0) | (1 << 1) | (1 << 2);
                if (index % 3 == 0 && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }

                // 3. 세로 ㅣ (3x1)
                check = (1 << 0) | (1 << 3) | (1 << 6);
                if (index + 6 < inbound && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }

                // 4. 역ㄱ (오른쪽 1칸짜리 빈 공간 있는 ㄱ모양) -> c가 0, 1이어야 함
                check = (1 << 0) | (1 << 1) | (1 << 3);
                if (index + 3 < inbound && index % 3 < 2 && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }

                // 5. ㄱ (오른쪽으로 뻗는 기본 ㄱ모양) -> c가 0, 1이어야 함
                check = (1 << 0) | (1 << 1) | (1 << 4);
                if (index + 4 < inbound && index % 3 < 2 && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }

                // 6. ㄴ (오른쪽으로 튀어나오는 L 모양) -> c가 0, 1이어야 함
                check = (1 << 0) | (1 << 3) | (1 << 4);
                if (index + 4 < inbound && index % 3 < 2 && (state & check) == 0) {
                    int nextState = (state | check) >> 1;
                    dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                }
            }
            before ^= 1;
            current ^= 1;
        }

        return dp[before][0];
    }
}