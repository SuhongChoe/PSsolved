import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static void read() throws IOException{
    	st = new StringTokenizer(br.readLine(), " ");
    }
    static int nextInt() {
    	return Integer.parseInt(st.nextToken());
    }
    
    public static class Point{
    	int quality;
    	char color;
    	Point(int quality, char color){
    		this.quality = quality;
    		this.color = color;
    	}
    	Point(int quality){
    		this.quality = quality;
    	}
    }
    
    static int n;
    static int res=0;
    static boolean[] visited;
    static Point[][][][] ingredent;
    
    static int calculator(Point[][] board) {
    	int r = 0;
    	int b = 0;
    	int g = 0;
    	int y = 0;
    	
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			if(board[i][j].color=='R') {
    				r+=board[i][j].quality;
    			} else if(board[i][j].color=='B') {
    				b+=board[i][j].quality;
    			} else if(board[i][j].color=='G') {
    				g+=board[i][j].quality;	
    			} else if(board[i][j].color=='Y') {
    				y+=board[i][j].quality;
    			}
    		}
    	}
    	
    	return 7*r + 5*b + 3*g + 2*y;
    }
    
    static void rotate() {
    	for(int k=0; k<n; k++) {
    		for(int d=1; d<4; d++) {
    			for(int i=0; i<4; i++) {
    				for(int j=0; j<4; j++) {
    					ingredent[k][d][i][j] = ingredent[k][d-1][j][3-i];
    				}
    			}
    		}
    	}
    }
    
    static void dfs(Point[][] board, int cnt) {
    	if(cnt==3) {
    		res = Math.max(res, calculator(board));
    		return;
    	}
    	for(int k=0; k<n; k++) {
    		if(!visited[k]) {
    			visited[k] = true;
    			for(int sy=0; sy<2; sy++) {
    				for(int sx=0; sx<2; sx++) {
    					for(int d=0; d<4; d++) {
    						Point[][] tmp = new Point[5][5];
    						for(int i=0; i<5; i++) {
    							for(int j=0; j<5; j++) {
    								tmp[i][j] = new Point(board[i][j].quality, board[i][j].color);
    							}
    						}
    						
    						for(int i=0; i<4; i++) {
    							for(int j=0; j<4; j++) {
    								tmp[sy+i][sx+j].quality += ingredent[k][d][i][j].quality;
    								if(tmp[sy+i][sx+j].quality>9) tmp[sy+i][sx+j].quality=9;
    								if(tmp[sy+i][sx+j].quality<0) tmp[sy+i][sx+j].quality=0;
    								if(ingredent[k][d][i][j].color!='W') tmp[sy+i][sx+j].color = ingredent[k][d][i][j].color;
    							}
    						}
    						
    						dfs(tmp, cnt+1);
    					}
    				}
    			}
    			visited[k] = false;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException{
    	read();
    	n = nextInt();
    	ingredent = new Point[n][4][4][4];
    	visited = new boolean[n];
    	
    	for(int k=0; k<n; k++) {
    		for(int i=0; i<4; i++) {
    			read();
    			for(int j=0; j<4; j++) {
    				ingredent[k][0][i][j] = new Point(nextInt());
    			}
    		}
    		
    		for(int i=0; i<4; i++) {
    			read();
    			for(int j=0; j<4; j++) {
    				ingredent[k][0][i][j].color = st.nextToken().charAt(0);
    			}
    		}
    	}
    	
    	rotate();
    	
//    	for(int k=0; k<n; k++) {
//    		for(int d=0; d<4; d++) {
//    			for(int i=0; i<4; i++) {
//    				for(int j=0; j<4; j++) {
//    					System.out.print("(" + ingredent[k][d][i][j].quality + ", " + ingredent[k][d][i][j].color + ")");
//    				}
//    				System.out.println();
//    			}
//    		}
//    	}
    	
    	Point[][] board = new Point[5][5];
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			board[i][j] = new Point(0, 'W');
    		}
    	}
    	
    	dfs(board, 0);
    	
    	System.out.print(res);
    	
    }
}