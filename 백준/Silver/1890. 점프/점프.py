import sys

def no_over(a, n):
	return 0<=a<n

def solution():
	input = sys.stdin.readline
	n = int(input())
	m = [list(map(int, input().split())) for _ in range(n)]
	answer = [[0]*n for _ in range(n)]
	answer[0][0]=1

	for row in range(n):
		for col in range(n):
			current = m[row][col]
			if answer[row][col]!=0 and current!=0:
				# continue
			# print(row, col, current, answer[row][col])
				if no_over(col+current, n):
					answer[row][col+current]+=answer[row][col]
				if no_over(row+current, n):
					answer[row+current][col]+=answer[row][col]

	print(answer[-1][-1])

solution()