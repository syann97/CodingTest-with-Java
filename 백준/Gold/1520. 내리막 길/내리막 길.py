from sys import stdin, setrecursionlimit

input = stdin.readline

N, M = map(int, input().split())
board = [[0] * (M+2)] + [[0] + list(map(int, input().split())) + [0] for _ in range(N)] + [[0] * (M+2)]
dp = [[0] * (M+2)] + [[0] + [-1] * M + [0] for _ in range(N)] + [[0] * (M+2)]
dp[1][1] = 1


def dfs(ci, cj):
    setrecursionlimit(10 ** 9)
    if dp[ci][cj] == -1:
        dp[ci][cj] = 0
        for di, dj in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            pi = ci + di
            pj = cj + dj
            if board[pi][pj] > board[ci][cj]:
                dp[ci][cj] += dfs(pi, pj)

    return dp[ci][cj]


print(dfs(N, M))