import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2)-> {
            int a1 = Math.abs(n1);
            int a2 = Math.abs(n2);

            if (a1==a2){
                return n1 - n2;
            }
            return a1 - a2;
        });

        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        int num;
        while(n-- > 0){
            num = Integer.parseInt(br.readLine());

            if (num!=0){
                pq.add(num);
            }
            else{
                num = !pq.isEmpty() ? pq.poll() : 0;
                sb.append(num).append("\n");
            }
        }

        System.out.print(sb);
    }
}