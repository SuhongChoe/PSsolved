import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1[0]==o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(n-- > 0){
            int num = Integer.parseInt(br.readLine());

            if (num!=0){
                pq.add(new int[] {Math.abs(num), num});
            }
            else{
                num = pq.isEmpty() ? 0 : pq.poll()[1];
                sb.append(num).append("\n");
            }
        }

        System.out.print(sb);
    }
}