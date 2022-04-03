import sys
from collections import deque
def solution():
	input = sys.stdin.readline

	n = int(''.join(input().split()))

	answer = [0]*10000
	a = 1
	for i in range(1111, 10000):
		tmp = deque(str(i))
		if answer[int(''.join(tmp))]==0 and not '0' in tmp:
			for _ in range(4):
				int_tmp = int(''.join(tmp))
				answer[int_tmp]=a
				tmp.rotate(-1)
			a+=1
	print(answer[n])



solution()