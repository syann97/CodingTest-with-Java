from sys import stdin
input = stdin.readline
N, K = map(int, input().split())
A = []
D = [[0] * (K+1) for _ in range(N)]

for _ in range(N):
    W, V = map(int, input().split())
    A.append((W, V))

A.sort(key=lambda x: (x[0], x[1]))
for i in range(A[0][0], K+1):
    D[0][i] = A[0][1]

for i in range(1, N):
    if A[i][0] <= K:
        D[i][A[i][0]] = max(D[i-1][A[i][0]], A[i][1])
    for j in range(A[0][0], K+1):
        if j+A[i][0] <= K and D[i-1][j-1] != D[i-1][j]:
            D[i][j+A[i][0]] = D[i-1][j] + A[i][1]
        D[i][j] = max(D[i-1][j], D[i][j-1], D[i][j])

print(D[N-1][-1])