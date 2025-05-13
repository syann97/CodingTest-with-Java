from sys import stdin
N = int(stdin.readline().rstrip())
A = list(map(int, stdin.readline().split()))
O = list(map(int, stdin.readline().split()))
max_v = -1e9
min_v = 1e9

def min_max(ans, n, a, s, m, d):
    global max_v, min_v
    if N == n:
        max_v = max(ans, max_v)
        min_v = min(ans, min_v)
        return
    else:
        if a:
            min_max(ans + A[n], n + 1, a - 1, s, m, d)
        if s:
            min_max(ans - A[n], n + 1, a, s - 1, m, d)
        if m:
            min_max(ans * A[n], n + 1, a, s, m - 1, d)
        if d:
            min_max(int(ans / A[n]), n + 1, a, s, m, d - 1)

min_max(A[0], 1, O[0], O[1], O[2], O[3])
print(f"{int(max_v)}\n{int(min_v)}")
