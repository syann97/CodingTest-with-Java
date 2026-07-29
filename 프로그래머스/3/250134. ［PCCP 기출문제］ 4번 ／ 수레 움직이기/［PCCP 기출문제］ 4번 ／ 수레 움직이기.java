class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static boolean[][] rVisited, bVisited;
    static int[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int answer;
    static int sry, srx;
    static int sby, sbx;
    static int ery, erx;
    static int eby, ebx;
    static int R, C;
    
    public int solution(int[][] maze) {
        init(maze);
        dfs(0, sry, srx, sby, sbx);
        return answer == MAX ? 0 : answer;
    }
    
    static boolean isWall(int ry, int rx, int by, int bx) {
        return board[ry][rx] == 5 || board[by][bx] == 5;
    }
    
    static boolean inbound(int ry, int rx, int by, int bx) {
        return 0 <= ry && ry < R && 0 <= rx && rx < C && 0 <= by && by < R && 0 <= bx && bx < C;
    }
    
    static void dfs(int turn, int ry, int rx, int by, int bx) {
        if (answer <= turn) return;
        
        boolean rFlag = rVisited[ery][erx];
        boolean bFlag = bVisited[eby][ebx];
        
        if (rFlag && bFlag) {
            answer = turn;
            return;
        }
        
        for (int rd = 0; rd < 4; rd++) {
            for (int bd = 0; bd < 4; bd++) {
                // 자신의 도착 칸에 위치한 수레는 움직이지 않습니다. 계속 해당 칸에 고정해 놓아야 합니다.
                int nry = ry + (rFlag ? 0 : dy[rd]);
                int nrx = rx + (rFlag ? 0 : dx[rd]);
                int nby = by + (bFlag ? 0 : dy[bd]);
                int nbx = bx + (bFlag ? 0 : dx[bd]);
                
                // 자신의 도착 칸에 위치한 수레는 움직이지 않습니다. 계속 해당 칸에 고정해 놓아야 합니다.
                
                // 수레는 벽이나 격자 판 밖으로 움직일 수 없습니다.
                if (!inbound(nry, nrx, nby, nbx) || isWall(nry, nrx, nby, nbx)) continue;
                // 수레는 자신이 방문했던 칸으로 움직일 수 없습니다.
                if ((!rFlag && rVisited[nry][nrx]) || (!bFlag && bVisited[nby][nbx])) continue;
                // 동시에 두 수레를 같은 칸으로 움직일 수 없습니다.
                if (nry == nby && nrx == nbx) continue;
                // 수레끼리 자리를 바꾸며 움직일 수 없습니다.
                if (nry == by && nrx == bx && nby == ry && nbx == rx) continue;
                
                rVisited[nry][nrx] = true;
                bVisited[nby][nbx] = true;
                dfs(turn + 1, nry, nrx, nby, nbx);
                rVisited[nry][nrx] = false;
                bVisited[nby][nbx] = false;
            }
        }
    }
                    
    
    
    
    static void init(int[][] maze) {
        answer = MAX;
        board = maze;
        R = board.length;
        C = board[0].length;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1) {
                    sry = i;
                    srx = j;
                }
                else if (board[i][j] == 2) {
                    sby = i;
                    sbx = j;
                }
                else if (board[i][j] == 3) {
                    ery = i;
                    erx = j;
                }
                else if (board[i][j] == 4) {
                    eby = i;
                    ebx = j;
                }
            }
        }
        
        rVisited = new boolean[R][C];
        bVisited = new boolean[R][C];
        rVisited[sry][srx] = true;
        bVisited[sby][sbx] = true;
    }
}