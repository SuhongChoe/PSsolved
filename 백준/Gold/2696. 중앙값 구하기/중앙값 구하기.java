import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(t-- > 0){
            PriorityQueue<Integer> right = new PriorityQueue<>();
            PriorityQueue<Integer> left = new PriorityQueue<>((n1,n2)->(n2-n1));

            int m = Integer.parseInt(br.readLine());
            sb.append((m-1)/2+1);
            for(int i=0; i<(m/10)+1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=i*10; j<Math.min(m,(i+1)*10); j++) {
                    int mid = Integer.parseInt(st.nextToken());

                    if (left.size() == right.size()){
                        left.add(mid);
                    } else {
                        right.add(mid);
                    }

                    if (j%20==0) sb.append("\n");

                    if (left.size() != right.size()){
                        if (!right.isEmpty() && left.peek() > right.peek()){
                            right.add(left.poll());
                            left.add(right.poll());
                        }
                        sb.append(left.peek()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
