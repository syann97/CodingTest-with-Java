from sys import stdin
n = int(stdin.readline().rstrip())
tile = [0] * (n+2)
tile[1:3] = [1, 2]
for i in range(3, n+1):
    tile[i] = (tile[i-1] + tile[i-2]) % 10007
print(tile[n])