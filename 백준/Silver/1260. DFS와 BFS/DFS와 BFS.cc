#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, V;
int c1[1001], c2[1001];
vector<int> v[1001];

void bfs(int start) {
	queue<int> q;
	q.push(start);
	c1[start] = true;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		printf("%d ", x);
		for (int i = 0; i < v[x].size(); i++) {
			int y = v[x][i];
			if (!c1[y]) {
				q.push(y);
				c1[y] = true;
			}
		}
	}
}

void dfs(int x) {
	if (c2[x]) return;
	c2[x] = true;
	printf("%d ", x);
	for (int i = 0; i < v[x].size(); i++) {
		int y = v[x][i];
		dfs(y);
	}
}
int main() {
	scanf("%d %d %d", &N, &M, &V);
	for (int i = 1; i <= M; i++) {
		int p1, p2;
		scanf("%d %d", &p1, &p2);
		v[p1].push_back(p2);
		v[p2].push_back(p1);
	}
	for (int i = 1; i <= N; i++)
		sort(v[i].begin(), v[i].end());
	dfs(V);
	printf("\n");
	bfs(V);
}