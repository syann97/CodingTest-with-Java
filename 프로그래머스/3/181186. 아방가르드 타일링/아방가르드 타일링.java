class Tile {
    String name;    // 디버깅용 이름
    int check;      // 타일이 차지하는 비트 마스크
    int maxOffset;  // (index + maxOffset)이 전체 칸수를 넘지 않는지 확인
    int minCol;     // 시작 가능한 최소 열 (index % 3)
    int maxCol;     // 시작 가능한 최대 열 (index % 3)

    Tile(String name, int check, int maxOffset, int minCol, int maxCol) {
        this.name = name;
        this.check = check;
        this.maxOffset = maxOffset;
        this.minCol = minCol;
        this.maxCol = maxCol;
    }
}

class Solution {
    static final int MOD = 1000000007;
    static int[] checks = {13, 7, 73, 11, 19, 25};
    static Tile[] tiles = {
        new Tile("역ㄴ", (1 << 0) | (1 << 2) | (1 << 3), 3, 1, 2),
        new Tile("ㅡ", (1 << 0) | (1 << 1) | (1 << 2), 2, 0, 0),
        new Tile("ㅣ", (1 << 0) | (1 << 3) | (1 << 6), 6, 0, 2),
        new Tile("역ㄱ", (1 << 0) | (1 << 1) | (1 << 3), 3, 0, 1),
        new Tile("ㄱ", (1 << 0) | (1 << 1) | (1 << 4), 4, 0, 1),
        new Tile("ㄴ", (1 << 0) | (1 << 3) | (1 << 4), 4, 0, 1)
    };
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

                int col = index % 3;

                for (Tile tile : tiles) {
                    if (index + tile.maxOffset < inbound && col >= tile.minCol && col <= tile.maxCol) {
                        if ((state & tile.check) == 0) {
                            int nextState = (state | tile.check) >> 1;
                            dp[current][nextState] = (dp[current][nextState] + dp[before][state]) % MOD;
                        }
                    }
                }
            }
            before ^= 1;
            current ^= 1;
        }

        return dp[before][0];
    }
}