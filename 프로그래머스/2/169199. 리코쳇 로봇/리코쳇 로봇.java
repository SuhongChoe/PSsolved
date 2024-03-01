import java.util.*;
import java.io.*;

class Solution {
    static class Point {
        int y;
        int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public int solution(String[] board) {
        int[] dy = new int[] {0,0,1,-1};
        int[] dx = new int[] {1,-1,0,0};
        int n = board.length;
        int m = board[0].length();
        
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j)=='R'){
                    startY = i;
                    startX = j;
                }
                if(board[i].charAt(j)=='G'){
                    endY = i;
                    endX = j;
                }
            }
        }
        
        Deque<Point> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(visited[i], -1);
        visited[startY][startX] = 0;
        q.addFirst(new Point(startY, startX));
        
        while(!q.isEmpty()){
            Point node = q.pollLast();
            
            for(int i=0; i<4; i++){
                int ny = node.y;
                int nx = node.x;
                
                while(ny >= 0 && ny < n && nx >= 0 && nx < m && board[ny].charAt(nx) != 'D'){
                    ny += dy[i];
                    nx += dx[i];
                }
                ny -= dy[i];
                nx -= dx[i];
                
                if(visited[ny][nx]==-1){
                    visited[ny][nx] = visited[node.y][node.x] + 1;
                    q.addFirst(new Point(ny, nx));
                }
            }
        }
        
        return visited[endY][endX];
    }
}