import sys
def solution():
	input = sys.stdin.readline
	ll = [int(input()) for _ in range(int(input()))]
	dp = [0]*300

	dp[0] = ll[0]
	if len(ll)>1: dp[1] = max(ll[0]+ll[1],ll[1])
	if len(ll)>2: dp[2] = max(ll[0]+ll[2],ll[1]+ll[2])

	for i in range(3, len(ll)):
		dp[i] = max(dp[i-2]+ll[i],dp[i-3]+ll[i-1]+ll[i])

	print(dp[len(ll)-1])
solution()