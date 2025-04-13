from sys import stdin, maxsize
n = int(stdin.readline().rstrip())
A = list(map(int, stdin.readline().split()))
A.sort()

left = 0
right = n-1
m = maxsize
n1 = maxsize
n2 = maxsize
count = 0

while left < right:
    sum_ = A[left] + A[right]
    if sum_ == 0:
        n1 = min(A[left], A[right])
        n2 = max(A[left], A[right])
        break

    sum_abs = abs(sum_)
    if m > sum_abs:
        m = sum_abs
        n1 = min(A[left], A[right])
        n2 = max(A[left], A[right])
    
    if sum_ < 0:
        left += 1

    elif sum_ > 0:
        right -= 1

print(n1, n2)