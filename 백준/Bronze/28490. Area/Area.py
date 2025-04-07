result = 0

for i in range(int(input())):
    a, b = map(int, input().split())
    result = max(result, a * b)
    
print(result)