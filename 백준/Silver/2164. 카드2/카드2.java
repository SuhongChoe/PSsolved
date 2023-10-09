import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            q.add(i);
        }

        while (q.size()>1){
            q.poll();
            q.add(q.poll());
        }

        System.out.print(q.poll());

    }
}
