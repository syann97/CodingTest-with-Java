from sys import stdin, maxsize
from bisect import bisect_left

n = int(stdin.readline().rstrip())
A = list(map(int, stdin.readline().split()))
tmp = [-maxsize]
dp = [1] * n

for i in range(n):
    if tmp[-1] < A[i]:
        dp[i] = len(tmp)
        tmp.append(A[i])
        
    else:
        change = bisect_left(tmp, A[i])
        dp[i] = change
        tmp[change] = A[i]

cnt = len(tmp) - 1
print(cnt)
p = []

for i in range(n-1, -1, -1):
    if dp[i] == cnt:
        p.append(A[i])
        cnt -= 1

print(*p[::-1])