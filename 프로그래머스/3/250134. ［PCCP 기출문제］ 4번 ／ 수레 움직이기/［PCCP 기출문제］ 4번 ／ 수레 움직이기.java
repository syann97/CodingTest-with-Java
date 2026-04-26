import java.util.*;




class Solution {
    static int sry, srx, sby, sbx;
    static int ery, erx, eby, ebx;
    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static final int MAX = 1000000;
    static int answer;
    static int[][] board;
    public int solution(int[][] maze) {
        init(maze);
        boolean[][] rVisited = new boolean[N][M];
        boolean[][] bVisited = new boolean[N][M];
        rVisited[sry][srx] = true;
        bVisited[sby][sbx] = true;
    
        dfs(sry, srx, sby, sbx, 0, rVisited, bVisited);
        // return answer == MAX ? 0 : answer;
        return answer == MAX ? 0 : answer;
    }
    

    
    
    // 각 턴마다 반드시 모든 수레를 상하좌우로 인접한 칸 중 한 칸으로 움직여야 함
    // 격자판 밖 이동 X
    // 도착 칸에 도착한 수레는 이동 X
    // 동시에 두 수레를 같은 칸으로 움직이기 X
    // 수레끼리 교체 X
    
    // 방문 분리
    static void dfs(int ry, int rx, int by, int bx, int turn, boolean[][] rVisited, boolean[][] bVisited) {
        if (turn >= answer) return;
        
        boolean rFlag = rVisited[ery][erx];
        boolean bFlag = bVisited[eby][ebx];
        
        // turn 갱신
        if (rFlag && bFlag) {
            answer = Math.min(answer, turn);
            return;
        }
        for (int rd = 0;  rd < 4; rd++) {
            for (int bd = 0; bd < 4; bd++) {
                int nry = ry + (rFlag ? 0 : dy[rd]);
                int nrx = rx + (rFlag ? 0 : dx[rd]);
                int nby = by + (bFlag ? 0 : dy[bd]);
                int nbx = bx + (bFlag ? 0 : dx[bd]);
                // 움직이지 못하는 조건 4가지 케이스 처방
                // 동시에 두 수레를 같은 칸으로 움직일 수 없습니다. -> 해결
                if (nry == nby && nrx == nbx) continue;
                // 수레끼리 자리를 바꾸며 움직일 수 없습니다. -> 해결                
                if (nry == by && nrx == bx && nby == ry && nbx == rx) continue;
                // 수레는 벽이나 격자 판 밖으로 움직일 수 없습니다. -> 인바운드 체킹 OR 벽 체킹 -> 해결
                if (!inbound(nry, nrx, nby, nbx) || isWall(nry, nrx, nby, nbx)) continue;
                if ((!rFlag && rVisited[nry][nrx]) || (!bFlag && bVisited[nby][nbx])) continue;
                // 아직 도착하지 않았을 경우는 무조건 이동해야하므로
                // 수레는 자신이 방문했던 칸으로 움직일 수 없습니다. -> 백트래킹
                
                if (!rFlag) rVisited[nry][nrx] = true;
                if (!bFlag) bVisited[nby][nbx] = true;
                dfs(nry, nrx, nby, nbx, turn + 1, rVisited, bVisited);
                if (!rFlag) rVisited[nry][nrx] = false;
                if (!bFlag) bVisited[nby][nbx] = false;
            }
        }
    }
    
    static boolean isWall(int ry, int rx, int by, int bx) {
        return board[ry][rx] == 5 || board[by][bx] == 5;
    }
    
    static boolean inbound(int ry, int rx, int by, int bx) {
        return 0 <= ry && ry < N && 0 <= rx && rx < M && 0 <= by && by < N && 0 <= bx && bx < M;
    } 
    
    
    static void init(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        answer = MAX;
        board = maze;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
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
    }
}