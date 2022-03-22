import sys

def solution():
	input = sys.stdin.readline

	m = [list([0]*101) for _ in range(101)]

	for _ in range(4):
		a, b, x, y = map(int, input().split())
		for i in range(b, y):
			for j in range(a, x):
				m[i][j]=1
	answer = 0
	for i in m:
		answer += i.count(1)

	print(answer)
solution()