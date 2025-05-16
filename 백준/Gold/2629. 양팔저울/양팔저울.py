from sys import stdin, stdout
N = int(stdin.readline().rstrip())
A = list(map(int, stdin.readline().split()))
M = int(stdin.readline().rstrip())
B = list(map(int, stdin.readline().split()))
P = []
DP = [[False] * 40001 for _ in range(N)]
DP[0][A[0]] = True

for i in range(1, N):
    DP[i][A[i]] = True
    for j in range(14501):
        if DP[i-1][j] == True:
            DP[i][j] = True
            DP[i][j+A[i]] = True
            DP[i][abs(j-A[i])] = True
    
for i in B:
    if DP[-1][i] == True:
        P.append("Y")
    else:
        P.append("N")

stdout.write(' '.join(P))