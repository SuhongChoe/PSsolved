import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(t-- > 0){
            PriorityQueue<Integer> right = new PriorityQueue<>((n1,n2)->(n1-n2));
            PriorityQueue<Integer> left = new PriorityQueue<>((n1,n2)->(n2-n1));

            int m = Integer.parseInt(br.readLine());
            int arr[] = new int[m];
            int j=0;
            for(int i=0; i<(int)(m/10)+1; i++){
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) arr[j++] = Integer.parseInt(st.nextToken());
            }

            sb.append((m-1)/2+1);
            for(int i=0; i<m; i++){
                int mid = arr[i];
                if(!left.isEmpty() && !right.isEmpty()){
                    int tmp[] = new int[] {left.poll(), mid, right.poll()};
                    Arrays.sort(tmp);
                    left.add(tmp[0]);
                    mid = tmp[1];
                    right.add(tmp[2]);
                }

                if (i%20==0) sb.append("\n");

                if(left.size()==right.size()){
                    sb.append(mid).append(" ");
                    left.add(mid);
                } else {
                    right.add(mid);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);



    }
}
