from sys import stdin, stdout
P = []
while True:
    a = list(map(int, stdin.readline().split()))

    if a[0] == 0:
        stdout.write('\n'.join(map(str, P)))
        break

    stack = []
    max_area = 0

    for i, height in enumerate(a[1:], start=1):
        
   
        if stack and stack[-1][1] > height:
            while stack: 
                stack_i, stack_height = stack.pop()
                start = 1
                if stack:
                    start = stack[-1][0]+1
                result = (i - start) * stack_height
                max_area = max(result, max_area)
            
                if not stack or stack[-1][1] <= height:
                    break

    
        if not stack or stack[-1][1] <= height:
            stack.append((i, height)) 

    while stack:
        stack_i, stack_height = stack.pop()
        start = 1
        if stack:
            start = stack[-1][0]+1
        result = (a[0]+1 - start) * stack_height
        max_area = max(result, max_area)
    P.append(max_area)