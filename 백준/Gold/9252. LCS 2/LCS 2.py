from sys import stdin
input = stdin.readline

A = input().rstrip()
B = input().rstrip()

lenA = len(A)
lenB = len(B)

dp = [[0] * (lenB+1) for _ in range(lenA+1)]

for i in range(1, lenA+1):
    for j in range(1, lenB+1):
        if A[i-1] == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

ans = dp[-1][-1]
p = []
i, j = lenA, lenB 

while i > 0 and j > 0:
    if dp[i][j] > dp[i][j-1]:
        p.append(B[j-1])
        i -= 1
        j -= 1
    elif dp[i][j] == dp[i-1][j]:
        i -= 1
    else:
        j -= 1

print(ans)        
print(''.join(map(str, p[::-1])))