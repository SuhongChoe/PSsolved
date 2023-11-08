import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] visited;

    static int findS, res=0;

    public static class Status{
        int s;
        int c;
        Status(int s, int c){
            this.s = s;
            this.c = c;
        }
    }

    static void bfs(){
        Deque<Status> q = new LinkedList<>();
        q.addFirst(new Status(1, 0));
        visited[1][0] = 0;

        while(!q.isEmpty()){
            Status x = q.pollLast();

            if(x.s==findS){
                System.out.print(visited[x.s][x.c]);
                return;
            }

            for(int[] next_x : new int[][] {{x.s, x.s}, {x.s+x.c, x.c}, {x.s-1, x.c}}){
                int s = next_x[0];
                int c = next_x[1];
                if(s >= 1 && s <= 1000 && c!=0 && visited[s][c]==1001){
                    visited[s][c] = visited[x.s][x.c] + 1;
                    q.addFirst(new Status(s, c));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        findS = Integer.parseInt(br.readLine());
        visited = new int[1001][1001];
        for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                visited[i][j] = 1001;
            }
        }

        bfs();
        
    }
    
}