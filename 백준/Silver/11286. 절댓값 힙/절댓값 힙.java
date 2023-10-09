import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> absheap = new PriorityQueue<>(n, (o1, o2)-> {
            int a1 = Math.abs(o1);
            int a2 = Math.abs(o2);

            if (a1==a2) return o1 - o2;
            return a1 - a2;
        });

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num!=0){
                absheap.add(num);
            } else {
                if(!absheap.isEmpty()){
                    sb.append(absheap.poll());
                } else{
                    sb.append("0");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);

    }
}
