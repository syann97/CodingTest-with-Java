from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().split())
A = [list(map(int, stdin.readline().split())) for _ in range(N)]
break_point = N * M
virus = deque([])
m = 0

for i in range(N):
    for j in range(M):
        if A[i][j] == 2:
            virus.append((i, j))


def bfs(li):
    global m
    area = [arr[:] for arr in A]
    start = virus.copy()

    while li:
        i, j = li.pop()
        area[i][j] = 1
    
    while start:
        i, j = start.popleft()

        for di, dj in [(0, -1), (0, 1), (-1, 0), (1, 0)]:
            ni, nj = di+i, dj+j
            if 0 <= ni < N and 0 <= nj < M and not area[ni][nj]:
                area[ni][nj] = 2                
                start.append((ni, nj))

    cnt = 0 
    for i in range(N):
        for j in range(M):
            if not area[i][j]:
                cnt += 1

    m = max(m, cnt)


def broute_force(n, p, li):
    if n == 3:
        bfs(li)
        return
    
    if p == break_point:
        return
    
    i = p // M
    j = p % M

    if A[i][j] == 0:
        broute_force(n+1, p+1, li + [(i, j)])
    broute_force(n, p+1, li)


broute_force(0, 0, [])
print(m)