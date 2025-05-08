from sys import stdin, maxsize
def read(): return stdin.readline().rstrip()
def reads(): return stdin.readline().split()

def diff(house, chicken):
    hi, hj = house
    ci, cj = chicken
    return abs(hi-ci) + abs(hj-cj)
    
N, M = map(int, reads())
area = [list(map(int, reads())) for _ in range(N)]

house = []
chicken = []

for i in range(N):
    for j in range(N):
        if area[i][j] == 1:
            house.append((i, j))
        elif area[i][j] == 2:
            chicken.append((i, j))

lc = len(chicken)
lh = len(house)

max_length = N ** 2
m = maxsize

def bf(i, n, tmp):
    global m
    if n == M:
        total = [max_length] * lh
        for i in range(lh):
            for j in range(M):
                total[i] = min(total[i], diff(tmp[j], house[i]))
        m = min(m, sum(total))
        return
    
    if lc <= i or M-n < M-i:
        return
        
    bf(i+1, n+1, tmp+[chicken[i]])
    bf(i+1, n, tmp)


bf(0, 0, [])
print(m)