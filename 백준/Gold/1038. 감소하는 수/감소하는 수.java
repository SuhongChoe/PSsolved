import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int x;

    static long BFS(){
        Deque<Long> q = new LinkedList<>();
        for(long i=0; i<10; i++) q.addFirst(i);
        int cnt = 0;
        
        while(!q.isEmpty()){
            long n = q.pollLast();

            if(cnt==x) return n;
            cnt++;
            
            for(int i=0; i<10; i++){
                if(n%10>i && n*10+i<=9876543210l) q.addFirst(n*10+i);
                else break;
            }
        }
        return (long) -1;
    }
    
    public static void main(String[] args) throws IOException {
        x = Integer.parseInt(br.readLine());
        System.out.print(BFS());
    }
}