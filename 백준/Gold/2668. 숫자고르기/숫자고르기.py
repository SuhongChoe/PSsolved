import sys

def solution():
	global answer
	input = sys.stdin.readline

	n = int(input())
	a_list = list(range(1,n+1))
	b_list = [int(input()) for _ in range(n)]

	answer = set()

	def DFS(a, check, a_check, b_check):
		global answer
		if a_check and a_check == b_check:
			answer |= a_check
			return
		if a in check:
			return
		b = b_list[a-1]
		check.add(a)
		a_check.add(a)
		b_check.add(b)

		DFS(b, check, a_check, b_check)

	for i in range(n):
		DFS(i+1,set(),set(),set())

	answer = sorted(answer)
	print(len(answer))
	for i in answer:
		print(i)

solution()