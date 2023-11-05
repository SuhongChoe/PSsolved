import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static char[][] graph;

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for(int i=0; i<n; i++) graph[i] = br.readLine().toCharArray();

        int res=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(0 <= ny && ny < n && 0 <= nx && nx < n){
                        char tmp = graph[i][j];
                        graph[i][j] = graph[ny][nx];
                        graph[ny][nx] = tmp;

                        int u, d, l, r;
                        u=i;
                        d=i;
                        l=j;
                        r=j;

                        while(u+1<n && graph[i][j]==graph[u+1][j]) u++;
                        while(d-1>=0 && graph[i][j]==graph[d-1][j]) d--;
                        while(r+1<n && graph[i][j]==graph[i][r+1]) r++;
                        while(l-1>=0 && graph[i][j]==graph[i][l-1]) l--;

                        res = Math.max(res, u-d+1);
                        res = Math.max(res, r-l+1);

                        tmp = graph[i][j];
                        graph[i][j] = graph[ny][nx];
                        graph[ny][nx] = tmp;
                    }
                }
            }
        }

        System.out.print(res);


    }

}
