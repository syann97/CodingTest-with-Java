from sys import stdin
def read(): return stdin.readline().rstrip()
def reads(): return stdin.readline().split()

n, s = map(int, reads())
A = list(map(int, reads()))
count = 0

def bf(idx, total):
    global count
    if idx >= n:
        if total and sum(total) == s:
            count += 1
        return
    
    bf(idx+1, total+[A[idx]])
    bf(idx+1, total)

bf(0, [])

print(count)