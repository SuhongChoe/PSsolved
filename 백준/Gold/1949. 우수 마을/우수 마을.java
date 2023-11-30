import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void read() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static int n;
	static int[] arr;
	static List<Integer>[] graph;
	static int[][] dp;
	static boolean[] visited;
	
	static void dfs(int cur) {
		visited[cur] = true;
		dp[cur][1] = arr[cur];
		
		for(int next : graph[cur]) {
			if(!visited[next]) {
				dfs(next);
				
				dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
				dp[cur][1] += dp[next][0];
			}
		}
		
		return;
	}
	
	public static void main(String[] args) throws IOException{
		read();
		n = nextInt();
		arr = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		
		read();
		for(int i=1; i<=n; i++) arr[i] = nextInt();
		
		for(int i=0; i<n-1; i++) {
			read();
			int a = nextInt();
			int b = nextInt();
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1);
		
		
		System.out.print(Math.max(dp[1][0], dp[1][1]));
		
		
	}
}