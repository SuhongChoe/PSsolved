from collections import deque
def solution():
	# 북:0 동:1 남:2 서:3
	dx = [0,1,0,-1]
	dy = [-1,0,1,0]

	# 북 서 남 동
	rotates = deque([0,3,2,1])

	N, M = map(int, input().split())
	r, c, d = map(int, input().split())
	while (rotates[0]!=d): rotates.rotate(-1)

	Map = [list(map(int, input().split())) for _ in range(N)]

	check_Map = [list(map(lambda x : True if x==0 else False, i)) for i in Map]
	answer = 0
	count = 0
	flag = True

	while True:
		# 1. 현재위치 청소
		if flag:
			answer += 1
			check_Map[r][c] = False
		# 2. 왼쪽 방향부터 차례대로 인접한 칸을 탐색
		# 2-a 청소하지 않았다면 그 방향으로 전진하고 1번으로 진행
		new_r = r+dy[rotates[1]]
		new_c = c+dx[rotates[1]]
		if check_Map[new_r][new_c] == True:
			r = new_r
			c = new_c
			rotates.rotate(-1)  # 방향전환
			count = 0
			flag = True
			continue
		# 2-b 왼쪽방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아감
		else:
			rotates.rotate(-1)
			count += 1
			# 2-c 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한칸 후진을 하고 2번으로 돌아간다
			if count == 4:
				# 후진
				new_r = r - dy[rotates[0]]
				new_c = c - dx[rotates[0]]
				if check_Map[new_r][new_c] == False and Map[new_r][new_c]==0:
					r = new_r
					c = new_c
					count = 0
				# 2-d 모두 벽이나 청소가 되있는 경우에서 후진도 못하면 작동 멈춤
				elif Map[new_r][new_c]==1:
					break
			flag = check_Map[r][c]
			continue

	print(answer)

solution()