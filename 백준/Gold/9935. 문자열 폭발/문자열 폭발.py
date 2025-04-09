from sys import stdin, stdout
s = stdin.readline().rstrip()
bomb = stdin.readline().rstrip()
stack = []

for i in range(len(s)):
    stack.append(s[i])
    if s[i] != bomb[-1]:
        continue
    if len(stack) >= len(bomb) and ''.join(stack[-len(bomb):]) == bomb:
        del stack[-len(bomb):]
    
if stack: stdout.write(''.join(stack))
else: stdout.write('FRULA')
